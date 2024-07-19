package com.demo_bank_v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {

    @Bean
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        // Set Properties
        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.debug","true");

        // Set Mail Credentials:
        emailConfig.setHost("sandbox.smtp.mailtrap.io");
        emailConfig.setPort(2525);
        emailConfig.setUsername("7ae4bdb59fcaca");
        emailConfig.setPassword("427b906cf33f52");

        return emailConfig;
    }
    // End of Email Config Method.
}
