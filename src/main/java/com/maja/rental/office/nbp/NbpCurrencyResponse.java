package com.maja.rental.office.nbp;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class NbpCurrencyResponse {

    private String code;
    private List<NbpCurrencyRateResponse> rates;

    @JsonCreator
    public NbpCurrencyResponse(String code, List<NbpCurrencyRateResponse> rates) {
        this.code = code;
        this.rates = rates;
    }

    public String getCode() {
        return code;
    }

    public List<NbpCurrencyRateResponse> getRates() {
        return rates;
    }
}
