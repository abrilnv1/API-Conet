package controllers;

import model.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@RestController
public class PaymentController {

    @Value("${conekta.api.key}")
    private String conektaApiKey;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/create-payment-link")
    public String createPaymentLink(@RequestBody PaymentRequest paymentRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString((conektaApiKey + ":").getBytes()));

        HttpEntity<PaymentRequest> entity = new HttpEntity<>(paymentRequest, headers);

        // Asumiendo que la URL de la API de Conekta es correcta y que tu modelo de solicitud coincide con lo que espera la API
        return restTemplate.postForObject("https://api.conekta.io/orders", entity, String.class);
    }
}
