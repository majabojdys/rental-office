package com.maja.rental.office.customers;

import com.maja.rental.office.rentals.Rental;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    private Long pesel;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;

    public Customer() {
    }

    public Customer(Long pesel, String firstName, String lastName) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(Long pesel, String firstName, String lastName, List<Rental> rentals) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rentals = rentals;
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

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(pesel, customer.pesel) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName);
    }

}
