package com.example.server.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Component
public class NotifierService {

    public NotifierService() {
    }

    public void sendSMS(String message) {
        final String ACCOUNT_SID = "";
        final String AUTH_TOKEN = "";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message mess = Message.creator(
                new PhoneNumber(""),
                new PhoneNumber(""),
                message).create();

        System.out.println(mess.getSid());
    }

    @SneakyThrows
    public void sendEmail(String message, String recipient) {
        String to = recipient;
        String from = "";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("", "");

            }

        });
        session.setDebug(true);

        try {
            MimeMessage mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(from));
            mess.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
            mess.setSubject("Credentials change for ArtGallery App");
            mess.setText(message);
            Transport.send(mess);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
