package com.maja.rental.office.rentaloffice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalOfficeRestController {

    private RentalOfficeService rentalOfficeService;

    public RentalOfficeRestController(RentalOfficeService rentalOfficeService) {
        this.rentalOfficeService = rentalOfficeService;
    }

    @PostMapping ("/rental-offices")
    public void addRentalOffice(@RequestBody AddRentalOfficeDtoRequest addRentalOfficeDtoRequest) {
        rentalOfficeService.addRentalOffice(addRentalOfficeDtoRequest);
    }

}
