package com.maja.rental.office.rentaloffice;

public final class AddRentalOfficeDtoRequest {

    private String name;
    private String countryCode;
    private String city;
    private String street;
    private Integer number;

    public AddRentalOfficeDtoRequest(String name, String countryCode, String city, String street, Integer number) {
        this.name = name;
        this.countryCode = countryCode;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }
}
