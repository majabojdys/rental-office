package com.maja.rental.office.rentals;

import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.equipment.Equipment;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rented_at")
    private LocalDateTime rentedAt;

    @Column(name = "returned_at")
    private LocalDateTime returnedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "rental_stock_id")
    private List<RentalStock> rentalStocks;


    public Rental() {
    }

    public Rental(LocalDateTime rentedAt, LocalDateTime returnedAt, Customer customer, List<RentalStock> rentalStocks) {
        this.rentedAt = rentedAt;
        this.returnedAt = returnedAt;
        this.customer = customer;
        this.rentalStocks = rentalStocks;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getRentedAt() {
        return rentedAt;
    }

    public Optional<LocalDateTime> getReturnedAt() {
        return Optional.ofNullable(returnedAt);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<RentalStock> getRentalStocks() {
        return rentalStocks;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }
}
