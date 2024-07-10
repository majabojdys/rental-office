package com.maja.rental.office.nbp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class NbpClient {

    private RestTemplate restTemplate;

    public NbpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<NbpCurrencyResponse> getCurrencyRate(String currencyCode) {
        try {
            ResponseEntity<NbpCurrencyResponse> response = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/A/" + currencyCode, NbpCurrencyResponse.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return Optional.ofNullable(response.getBody());
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
