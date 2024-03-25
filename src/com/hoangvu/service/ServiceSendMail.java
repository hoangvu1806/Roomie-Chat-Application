package com.hoangvu.service;

import com.hoangvu.model.ModelMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServiceSendMail {
    public ModelMessage sendMain(String toEmail,String userName, String verifyCode) {
        ModelMessage ms = new ModelMessage(false, "");
        String from = "roomie.app18@gmail.com";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        String username = "roomie.app18@gmail.com";
        String password = "hbovjhpavntqyhsq";
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Verify Your Roomie Account");
            String emailContent = "<html>"
                    + "<head>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; }"
                    + "p { font-size: 16px; }"
                    + "strong { font-size: 18px; font-weight: bold; }"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<p>Dear " + userName + ",</p>"
                    + "<p>Thank you for registering with <strong>Roomie</strong>.</p>"
                    + "<p>Please use the following verification code to activate your account:</p>"
                    + "<p><strong>Verification Code:</strong> <span style='font-size:20px;'>" + verifyCode + "</span></p>"
                    + "<p>If you did not register for a Roomie account, please ignore this email.</p>"
                    + "<p>Best regards,<br/>Dev Vu Hoang</p>"
                    + "<p>If you encounter any issues, please don't hesitate to <a href='https://www.facebook.com/hoangvu.nt1806/'>contact me</a> via Facebook.</p>" // Thêm liên kết đến trang Facebook của bạn
                    + "</body>"
                    + "</html>";
            message.setContent(emailContent, "text/html");
            Transport.send(message);
            ms.setSuccess(true);
        } catch (MessagingException e) {
            if (e.getMessage().equals("Invalid Addresses")) {
                System.out.println("in sendMail: "+ toEmail);
                ms.setMessage("Invalid email");
            } else {

                System.out.println(e);
                ms.setMessage("Error");
            }
        }
        return ms;
    }
}
