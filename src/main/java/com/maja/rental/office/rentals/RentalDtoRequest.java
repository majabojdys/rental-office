package com.maja.rental.office.rentals;

import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.equipment.Equipment;
import com.maja.rental.office.equipment.EquipmentSize;
import com.maja.rental.office.equipment.EquipmentType;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class RentalDtoRequest {

    private EquipmentType type;

    private EquipmentSize size;

    private Integer quantity;

    private Long rentalOfficeId;

    public RentalDtoRequest(EquipmentType type, EquipmentSize size, Integer quantity, Long rentalOfficeId) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.rentalOfficeId = rentalOfficeId;
    }

    public EquipmentType getType() {
        return type;
    }

    public EquipmentSize getSize() {
        return size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getRentalOfficeId() {
        return rentalOfficeId;
    }

}
