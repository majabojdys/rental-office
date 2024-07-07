package com.maja.rental.office.rentaloffice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

public class RentalOfficeServiceTest {

    private RentalOfficeRepository rentalOfficeRepository = Mockito.mock(RentalOfficeRepository.class);
    private RentalOfficeService rentalOfficeService = new RentalOfficeService(rentalOfficeRepository);

    @Test
    public void testMappingRentalOfficeAddition(){
        //given
        String name = "biuro1";
        String countryCode = "PL";
        String city = "Gliwice";
        String street = "Kowalska";
        Integer number = 23;
        AddRentalOfficeDtoRequest request = new AddRentalOfficeDtoRequest(name, countryCode, city, street, number);

        //when
        rentalOfficeService.addRentalOffice(request);

        //then
        RentalOfficeAddress address = new RentalOfficeAddress(countryCode, city, street, number);
        RentalOffice rentalOffice = new RentalOffice(address, name);
        Mockito.verify(rentalOfficeRepository).save(rentalOffice);
    }


    @Test
    public void testGettingByIdRentalOffice(){
        //given
        Long id = 1L;
        String name = "biuro1";
        String countryCode = "PL";
        String city = "Gliwice";
        String street = "Kowalska";
        Integer number = 23;
        RentalOfficeAddress address = new RentalOfficeAddress(countryCode, city, street, number);
        RentalOffice rentalOffice = new RentalOffice(address, name);
        Mockito.when(rentalOfficeRepository.findById(id)).thenReturn(Optional.of(rentalOffice));

        //when
        GetRentalOfficeDtoResponse response = rentalOfficeService.getRentalOfficeById(id);

        //then
        Assertions.assertEquals(name, response.getName());
        Assertions.assertEquals(countryCode, response.getCountryCode());
        Assertions.assertEquals(city, response.getCity());
        Assertions.assertEquals(street, response.getStreet());
        Assertions.assertEquals(number, response.getNumber());
    }


    @Test
    public void testGettingAllOffices(){
        //given
        String name = "biuro1";
        String countryCode = "PL";
        String city = "Gliwice";
        String street = "Kowalska";
        Integer number = 23;
        RentalOfficeAddress address = new RentalOfficeAddress(countryCode, city, street, number);
        RentalOffice rentalOffice = new RentalOffice(address, name);
        Mockito.when(rentalOfficeRepository.findAll()).thenReturn(List.of(rentalOffice));

        //when
        List<GetRentalOfficeDtoResponse> response = rentalOfficeService.getRentalOffices();

        //then
        Assertions.assertEquals(name, response.get(0).getName());
        Assertions.assertEquals(countryCode, response.get(0).getCountryCode());
        Assertions.assertEquals(city, response.get(0).getCity());
        Assertions.assertEquals(street, response.get(0).getStreet());
        Assertions.assertEquals(number, response.get(0).getNumber());

    }
}
