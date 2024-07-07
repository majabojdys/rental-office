package com.maja.rental.office.rentaloffice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalOfficeRestController {

    private RentalOfficeService rentalOfficeService;


    public RentalOfficeRestController(RentalOfficeService rentalOfficeService) {
        this.rentalOfficeService = rentalOfficeService;
    }

    @PostMapping("/rental-offices")
    public void addRentalOffice(@RequestBody AddRentalOfficeDtoRequest addRentalOfficeDtoRequest) {
        rentalOfficeService.addRentalOffice(addRentalOfficeDtoRequest);
    }

    @GetMapping("/rental-offices")
    public List<GetRentalOfficeDtoResponse> getRentalOffices(){
        return rentalOfficeService.getRentalOffices();
    }

    @GetMapping("/rental-offices/{id}")
    public GetRentalOfficeDtoResponse getRentalOfficeById(@PathVariable Long id){
        return rentalOfficeService.getRentalOfficeById(id);
    }

}
