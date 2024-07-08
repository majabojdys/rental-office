package com.maja.rental.office.rentaloffice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetRentalOficeByIdIntegrationTest extends IntegrationTest{

    @Test
    public void getRentalOfficeById() {
        //given
        String name = "biuro1";
        String countryCode = "PL";
        String city = "Gliwice";
        String street = "Kowalska";
        Integer number = 23;
        RentalOfficeAddress rentalOfficeAddress = new RentalOfficeAddress(countryCode, city, street, number);
        RentalOffice rentalOffice = new RentalOffice(rentalOfficeAddress, name);
        rentalOfficeRepository.save(rentalOffice);

        //when
        ResponseEntity<GetRentalOfficeDtoResponse> response = restTemplate.getForEntity(getLocalhost() + "/rental-offices/1", GetRentalOfficeDtoResponse.class);

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Assertions.assertEquals(name, response.getBody().getName());
        Assertions.assertEquals(countryCode, response.getBody().getCountryCode());
        Assertions.assertEquals(city, response.getBody().getCity());
        Assertions.assertEquals(street, response.getBody().getStreet());
        Assertions.assertEquals(number, response.getBody().getNumber());

    }
}
