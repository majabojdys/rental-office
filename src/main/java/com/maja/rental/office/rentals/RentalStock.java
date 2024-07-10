package com.maja.rental.office.rentals;

import com.maja.rental.office.equipment.Equipment;
import jakarta.persistence.*;

@Entity
@Table(name = "rental_stocks")
public class RentalStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @OneToOne
    private Equipment equipment;

    public RentalStock() {
    }

    public RentalStock(Integer quantity, Equipment equipment) {
        this.quantity = quantity;
        this.equipment = equipment;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
