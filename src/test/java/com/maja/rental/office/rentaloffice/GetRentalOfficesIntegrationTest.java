package com.maja.rental.office.rentaloffice;

import com.maja.rental.office.IntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.List;

public class GetRentalOfficesIntegrationTest extends IntegrationTest {

    @Test
    public void getRentalOffices(){
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
        ResponseEntity<List<GetRentalOfficeDtoResponse>> response = restTemplate.exchange(getLocalhost() + "/rental-offices", HttpMethod.GET, null, new ParameterizedTypeReference<>(){});

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Assertions.assertEquals(name, response.getBody().get(0).getName());
        Assertions.assertEquals(countryCode, response.getBody().get(0).getCountryCode());
        Assertions.assertEquals(city, response.getBody().get(0).getCity());
        Assertions.assertEquals(street, response.getBody().get(0).getStreet());
        Assertions.assertEquals(number, response.getBody().get(0).getNumber());
    }

}
