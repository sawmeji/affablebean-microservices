package com.example.apisecurity.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private final JavaMailSender javaMailSender;
    private final String defaultFrontendUrl;

    public MailService(JavaMailSender javaMailSender,
                       @Value("${application.frontend.default.url}") String defaultFrontendUrl) {
        this.javaMailSender = javaMailSender;
        this.defaultFrontendUrl = defaultFrontendUrl;
    }

    public void sendForgotMessage(String email, String token, String baseUrl){
        var url = baseUrl != null ? baseUrl : defaultFrontendUrl;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("jdc@javalab.com");
        message.setTo(email);
        message.setSubject("Reset Your Password!");
        message.setText(String.format("Click <a href=\"%s/reset/%s\">here</a> to reset your Password!",
                url,
                token));

        javaMailSender.send(message);
    }

}
