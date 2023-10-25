package com.microservices.Services;
import com.microservices.Model.stripe;
import com.microservices.Model.stripeCharge;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class stripeService {

  //  private String stripeApiKey="sk_test_51O21kVDul0YbpIGQv4x5hAHco4GuwIHp4UG3LgckXhVz1xtPoSaUeSnDjcWDtIB2vZ59YbECtF53TzX3v02odful00YyP0ttTt";
//sk_test_4eC39HqLyjWDarjtT1zdp7dc

    @Value("${stripe.api.publicKey}")
    private String stripeApiKey;
    @Value("${stripe.api.privateKey}")
    private String stripeKey;

    @PostConstruct
    public void init1(){
        Stripe.apiKey = stripeApiKey;
    }
    @PostConstruct
    public void init(){
        Stripe.apiKey = stripeKey;
    }
    public stripe createCardToken(stripe model){




        try {
            Map<String, Object> card = new HashMap<>();
            card.put("number", model.getCardNumber());
            card.put("exp_month", Integer.parseInt(model.getExpMonth()));
            card.put("exp_year", Integer.parseInt(model.getExpYear()));
            card.put("cvc", model.getCvc());
            Map<String, Object> params = new HashMap<>();
            params.put("card", card);
            Token token = Token.create(params);

            if (token != null && token.getId() != null) {
                model.setSuccess(true);
                model.setToken(token.getId());
            }
            return model;
        } catch (StripeException e) {
            log.error("StripeService (createCardToken)", e);
            throw new RuntimeException(e.getMessage());
        }




    }
    public stripeCharge charge(stripeCharge chargeRequest)  {
      Stripe.apiKey=stripeKey;
        try {
            chargeRequest.setSuccess(false);
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", (int) (chargeRequest.getAmount() * 100));
            chargeParams.put("currency", "USD");
            chargeParams.put("description", "Payment for id " + chargeRequest.getAdditionalInfo().getOrDefault("ID_TAG", ""));
            chargeParams.put("source", chargeRequest.getStripeToken());
            Map<String, Object> metaData = new HashMap<>();
            metaData.put("id", chargeRequest.getChargeId());
            metaData.putAll(chargeRequest.getAdditionalInfo());
            chargeParams.put("metadata", metaData);
            Charge charge = Charge.create(chargeParams);
            chargeRequest.setMessage(charge.getOutcome().getSellerMessage());

            if (charge.getPaid()) {
                chargeRequest.setChargeId(charge.getId());
                chargeRequest.setSuccess(true);

            }
            return chargeRequest;
        } catch (StripeException e) {
            log.error("StripeService (charge)", e);
            throw new RuntimeException(e.getMessage());
        }


    }

}
