package com.maja.rental.office.customers;

import java.util.Optional;

public class CustomerDtoResponse {

    private Long pesel;
    private String firstName;
    private String lastName;
    private Double charge;
    private Double chargeInEuro;

    public CustomerDtoResponse(Long pesel, String firstName, String lastName, Double charge, Double chargeInEuro) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.charge = charge;
        this.chargeInEuro = chargeInEuro;
    }

    public Long getPesel() {
        return pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getCharge() {
        return charge;
    }

    public Optional<Double> getChargeInEuro() {
        return Optional.ofNullable(chargeInEuro);
    }
}
