package com.maja.rental.office.equipment;

import java.math.BigDecimal;

public class EquipmentDtoResponse {

    private Long rentalOfficeId;
    private String rentalOfficeName;
    private EquipmentType type;
    private EquipmentSize size;
    private Double pricePerDay;
    private Integer quantity;

    public EquipmentDtoResponse(Long rentalOfficeId, String rentalOfficeName, EquipmentType type, EquipmentSize size, Double pricePerDay, Integer quantity) {
        this.rentalOfficeId = rentalOfficeId;
        this.rentalOfficeName = rentalOfficeName;
        this.type = type;
        this.size = size;
        this.pricePerDay = pricePerDay;
        this.quantity = quantity;
    }

    public Long getRentalOfficeId() {
        return rentalOfficeId;
    }

    public String getRentalOfficeName() {
        return rentalOfficeName;
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
