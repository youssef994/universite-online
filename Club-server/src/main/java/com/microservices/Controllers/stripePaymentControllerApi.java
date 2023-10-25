package com.microservices.Controllers;

import com.microservices.Model.stripe;
import com.microservices.Model.stripeCharge;
import com.microservices.Services.stripeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stripe-api")
public class stripePaymentControllerApi {
   private final stripeService stripeService;

   @PostMapping("/card/token")
   @ResponseBody
   public stripe createCardToken(@RequestBody stripe model){
      return stripeService.createCardToken(model);
   }
   @PostMapping("/charge")
   @ResponseBody
   public stripeCharge charge(@RequestBody stripeCharge model){
      return stripeService.charge(model);
   }

}
