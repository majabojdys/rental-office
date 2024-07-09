package com.maja.rental.office.equipment;

import com.maja.rental.office.rentaloffice.RentalOffice;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long equipmentId;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private RentalOffice rentalOffice;

    @Enumerated(EnumType.STRING)
    private EquipmentType type;

    @Enumerated(EnumType.STRING)
    private EquipmentSize size;

    @Column(name = "price_per_day")
    private Double pricePerDay;

    private Integer quantity;

    public Equipment() {
    }

    public Equipment(RentalOffice rentalOffice, EquipmentType type, EquipmentSize size, Double pricePerDay, Integer quantity) {
        this.rentalOffice = rentalOffice;
        this.type = type;
        this.size = size;
        this.pricePerDay = pricePerDay;
        this.quantity = quantity;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public RentalOffice getRentalOffice() {
        return rentalOffice;
    }

    public EquipmentType getType() {
        return type;
    }

    public EquipmentSize getSize() {
        return size;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(equipmentId, equipment.equipmentId) && Objects.equals(rentalOffice, equipment.rentalOffice) && type == equipment.type && size == equipment.size && Objects.equals(pricePerDay, equipment.pricePerDay) && Objects.equals(quantity, equipment.quantity);
    }

}
