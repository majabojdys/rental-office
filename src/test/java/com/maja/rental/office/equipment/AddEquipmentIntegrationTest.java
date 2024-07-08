package com.maja.rental.office.equipment;

import com.maja.rental.office.IntegrationTest;
import com.maja.rental.office.rentaloffice.RentalOffice;
import com.maja.rental.office.rentaloffice.RentalOfficeAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public class AddEquipmentIntegrationTest extends IntegrationTest {

    @Test
    public void testEquipmentAddition(){
        //given
        EquipmentType type = EquipmentType.SKIS;
        EquipmentSize size = EquipmentSize.L;
        Double price = 10.00;
        EquipmentDtoRequest request = new EquipmentDtoRequest(type, size, price);
        RentalOfficeAddress rentalOfficeAddress = new RentalOfficeAddress("PL", "Katowice", "Zwycięstwa",45);
        RentalOffice rentalOffice = new RentalOffice(rentalOfficeAddress, "nazwa3");
        Long rentalOfficeId = rentalOfficeRepository.save(rentalOffice).getRentalOfficeId();

        //when
        ResponseEntity<Void> response = restTemplate.postForEntity(getLocalhost() + "/rental-offices/" + rentalOfficeId + "/equipments", request, Void.class);

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Equipment equipment = equipmentRepository.findAll().get(0);
        Assertions.assertEquals(type, equipment.getType());
        Assertions.assertEquals(size, equipment.getSize());
        Assertions.assertEquals(price, equipment.getPricePerDay());
        Assertions.assertEquals(rentalOffice, equipment.getRentalOffice());
    }
}
