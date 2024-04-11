package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendPaymentLinkEmail(String to, String paymentLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-reply@example.com");
        message.setTo(to);
        message.setSubject("Tu link de pago");
        message.setText("Gracias por tu compra. Aquí está tu link de pago: " + paymentLink);
        emailSender.send(message);
    }
}