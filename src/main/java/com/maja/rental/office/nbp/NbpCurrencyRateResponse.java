package com.maja.rental.office.nbp;

import com.fasterxml.jackson.annotation.JsonCreator;

public class NbpCurrencyRateResponse {

    private Double mid;

    @JsonCreator
    public NbpCurrencyRateResponse(Double mid) {
        this.mid = mid;
    }

    public Double getMid() {
        return mid;
    }
}
