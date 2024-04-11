package controllers;

import service.EmailService;
import model.PaymentNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentWebhookController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/payment-notification")
    public void handlePaymentNotification(@RequestBody PaymentNotification notification) {
        emailService.sendPaymentLinkEmail(notification.getEmail(), notification.getPaymentLink());
    }
}