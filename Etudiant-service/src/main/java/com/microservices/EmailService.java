package com.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailService {


    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true); // true indique que le texte est au format HTML, vous pouvez le changer en false si vous envoyez du texte brut

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Gérez l'exception comme vous le souhaitez, par exemple, en journalisant l'erreur
            throw new RuntimeException("Erreur lors de l'envoi de l'e-mail", e);
        }
    }

}
