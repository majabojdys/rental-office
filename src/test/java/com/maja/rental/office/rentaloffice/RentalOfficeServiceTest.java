package com.maja.rental.office.rentaloffice;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

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
}
