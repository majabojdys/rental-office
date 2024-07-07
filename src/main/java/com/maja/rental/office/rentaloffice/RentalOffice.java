package com.maja.rental.office.rentaloffice;


import jakarta.persistence.*;

@Entity
@Table(name = "rental_offices")
public class RentalOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_office_id", referencedColumnName = "rental_office_id")
    private RentalOfficeAddress address;

    public RentalOffice() {
    }

    public RentalOffice(RentalOfficeAddress address, String name) {
        this.address = address;
        this.name = name;
    }

    public Long getRentalOfficeId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public RentalOfficeAddress getAddress() {
        return address;
    }
}
