package com.maja.rental.office.customers;

public class CustomerDtoResponse {

    private Long pesel;
    private String firstName;
    private String lastName;
    private Double charge;

    public CustomerDtoResponse(Long pesel, String firstName, String lastName, Double charge) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.charge = charge;
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
}
