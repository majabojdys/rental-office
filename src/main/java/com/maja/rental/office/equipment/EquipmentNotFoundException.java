package com.maja.rental.office.equipment;

public class EquipmentNotFoundException extends RuntimeException{

    public EquipmentNotFoundException(String message) {
        super(message);
    }
}
