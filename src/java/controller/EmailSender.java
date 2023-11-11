package controller;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public static void sendPaymentSuccessEmail(String to, int orderId) throws MessagingException {
        final String username = "nguyennhatanh.dev@gmail.com"; // Thay bằng địa chỉ email của bạn
        final String password = "zrmx adoj amvv pjza"; // Thay bằng mật khẩu email của bạn

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Sử dụng SMTP server của nhà cung cấp email của bạn
        props.put("mail.smtp.port", "587"); // Sử dụng cổng phù hợp

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Payment Success - Order #" + orderId);
        message.setText("Dear Customer,\n\n"
                + "Your payment for Order #" + orderId + " has been successfully processed.\n"
                + "Thank you for choosing our service!\n\n"
                + "Best regards,\nYour Company Name");

        Transport.send(message);
    }
}
