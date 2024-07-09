package com.maja.rental.office.rentals;

import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.customers.CustomerDtoResponse;
import com.maja.rental.office.equipment.Equipment;
import com.maja.rental.office.equipment.EquipmentDtoResponse;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class RentalDtoResponse {

    private Long id;

    private LocalDateTime rentedAt;

    private LocalDateTime returnedAt;

    private CustomerDtoResponse customerDtoResponse;

    private List<EquipmentDtoResponse> equipmentsDtoResponse;

}
