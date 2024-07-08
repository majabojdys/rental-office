package com.maja.rental.office.equipment;

import java.math.BigDecimal;

public class EquipmentDtoRequest {

    private EquipmentType type;
    private EquipmentSize size;
    private Double pricePerDay;

    public EquipmentDtoRequest(EquipmentType type, EquipmentSize size, Double pricePerDay) {
        this.type = type;
        this.size = size;
        this.pricePerDay = pricePerDay;
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
}
