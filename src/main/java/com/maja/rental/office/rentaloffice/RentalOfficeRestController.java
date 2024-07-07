package com.maja.rental.office.rentaloffice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalOfficeRestController {

    private RentalOfficeService rentalOfficeService;

    public RentalOfficeRestController(RentalOfficeService rentalOfficeService) {
        this.rentalOfficeService = rentalOfficeService;
    }

    @PostMapping ("/rental-offices")
    public void addRentalOffice(AddRentalOfficeDtoRequest addRentalOfficeDtoRequest) {
        rentalOfficeService.addRentalOffice(addRentalOfficeDtoRequest);
    }

}
