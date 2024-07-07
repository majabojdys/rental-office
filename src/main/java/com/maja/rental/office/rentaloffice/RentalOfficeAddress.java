package com.maja.rental.office.rentaloffice;

import jakarta.persistence.*;

@Entity
@Table(name = "rental_office_addresses")
public class RentalOfficeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_office_id")
    private Long rentalOfficeId;
    private String countryCode;
    private String city;
    private String street;
    private Integer number;


    public RentalOfficeAddress() {
    }

    public RentalOfficeAddress(String countryCode, String city, String street, Integer number) {
        this.countryCode = countryCode;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public Long getRentalOfficeId() {
        return rentalOfficeId;
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
