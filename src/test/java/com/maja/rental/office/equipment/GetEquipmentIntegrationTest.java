package com.maja.rental.office.equipment;

import com.maja.rental.office.IntegrationTest;
import com.maja.rental.office.rentaloffice.GetRentalOfficeDtoResponse;
import com.maja.rental.office.rentaloffice.RentalOffice;
import com.maja.rental.office.rentaloffice.RentalOfficeAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetEquipmentIntegrationTest extends IntegrationTest {

    @Test
    public void getEquipmentIntegrationTest(){
        //given
        EquipmentType type = EquipmentType.SKIS;
        EquipmentSize size = EquipmentSize.L;
        Double price = 10.00;
        Integer quantity = 2;
        RentalOfficeAddress rentalOfficeAddress = new RentalOfficeAddress("PL", "Katowice", "Zwycięstwa",45);
        RentalOffice rentalOffice = new RentalOffice(rentalOfficeAddress, "nazwa3");
        rentalOfficeRepository.save(rentalOffice);
        Equipment equipment = new Equipment(rentalOffice, type, size, price, quantity);
        equipmentRepository.save(equipment);

        //when
        ResponseEntity<EquipmentDtoResponse> response = restTemplate.getForEntity(getLocalhost() + "/rental-offices/1/equipments?type=SKIS&size=L", EquipmentDtoResponse.class);

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Assertions.assertEquals(type, response.getBody().getType());
        Assertions.assertEquals(size, response.getBody().getSize());
        Assertions.assertEquals(price, response.getBody().getPricePerDay());
        Assertions.assertEquals(quantity, response.getBody().getQuantity());
        Assertions.assertEquals(1L, response.getBody().getRentalOfficeId());
    }
}
