package com.microservices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // Configure your email server properties here
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587); // Set the appropriate port
        mailSender.setUsername("melekboughanmi2023@gmail.com");
        mailSender.setPassword("tjnceolxwpkxpjvp");

        // Configuration TLS
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Active STARTTLS
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Indiquez le serveur de confiance

        return mailSender;
    }
}
