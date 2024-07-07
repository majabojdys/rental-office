package com.maja.rental.office.rentaloffice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RentalOfficeAdditionIntegrationTest extends IntegrationTest {

    @Test
    public void testAdditionRentalOffice() {
        //given
        String name = "biuro1";
        String countryCode = "PL";
        String city = "Gliwice";
        String street = "Kowalska";
        Integer number = 23;
        AddRentalOfficeDtoRequest request = new AddRentalOfficeDtoRequest(name, countryCode, city, street, number);

        //when
        ResponseEntity<Void> response = restTemplate.postForEntity(getLocalhost() + "/rental-offices", request, Void.class);

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        RentalOffice rentalOffice = rentalOfficeRepository.findAll().get(0);
        Assertions.assertEquals(name, rentalOffice.getName());
        Assertions.assertEquals(countryCode, rentalOffice.getAddress().getCountryCode());
        Assertions.assertEquals(city, rentalOffice.getAddress().getCity());
        Assertions.assertEquals(street, rentalOffice.getAddress().getStreet());
        Assertions.assertEquals(number, rentalOffice.getAddress().getNumber());
    }

}
