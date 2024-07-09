package com.maja.rental.office.customers;

public class CustomerDtoResponse {

    private Long pesel;
    private String firstName;
    private String lastName;

    public CustomerDtoResponse(Long pesel, String firstName, String lastName) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
