package service;

import model.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;


@Service
public class PaymentService {

    private final RestTemplate restTemplate;

    @Value("${conekta.apiKey}")
    private String conektaApiKey;

    // Inyecta el valor de conekta.api.url a nivel de clase
    @Value("${conekta.api.url}")
    private String conektaApiUrl;

    @Autowired
    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String createPaymentLink(OrderRequest orderRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString((conektaApiKey + ":").getBytes()));

        HttpEntity<OrderRequest> entity = new HttpEntity<>(orderRequest, headers);

        try {
            String url = conektaApiUrl + "/orders";
            String response = restTemplate.postForObject(url, entity, String.class);
            // Procesar y devolver la respuesta, por ejemplo, un link de pago
            return response; // Aquí deberías extraer el link de pago de la respuesta
        } catch (Exception e) {
            // Manejar la excepción adecuadamente
            e.printStackTrace();
            return "Error al crear el link de pago";
        }
    }
}
