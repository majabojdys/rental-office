package com.maja.rental.office.equipment;

import java.math.BigDecimal;

public class EquipmentDtoResponse {

    private Long rentalOfficeId;
    private String rentalOfficeName;
    private EquipmentType type;
    private EquipmentSize size;
    private Double pricePerDay;

    public EquipmentDtoResponse(Long rentalOfficeId, String rentalOfficeName, EquipmentType type, EquipmentSize size, Double pricePerDay) {
        this.rentalOfficeId = rentalOfficeId;
        this.rentalOfficeName = rentalOfficeName;
        this.type = type;
        this.size = size;
        this.pricePerDay = pricePerDay;
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
}
