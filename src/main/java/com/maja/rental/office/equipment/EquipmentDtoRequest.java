package com.maja.rental.office.equipment;

import java.math.BigDecimal;

public class EquipmentDtoRequest {

    private EquipmentType type;
    private EquipmentSize size;
    private Double pricePerDay;
    private Integer quantity;

    public EquipmentDtoRequest(EquipmentType type, EquipmentSize size, Double pricePerDay, Integer quantity) {
        this.type = type;
        this.size = size;
        this.pricePerDay = pricePerDay;
        this.quantity = quantity;
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

}
