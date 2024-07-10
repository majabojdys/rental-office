package com.maja.rental.office.nbp;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class NbpService {

    private NbpClient nbpClient;

    public NbpService(NbpClient nbpClient) {
        this.nbpClient = nbpClient;
    }

    public Optional<Double> getEuroRate(){
        return nbpClient.getCurrencyRate("EUR")
                .map(response -> response.getRates().get(0).getMid());
    }
}
