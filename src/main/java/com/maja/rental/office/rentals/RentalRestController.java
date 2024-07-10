package com.maja.rental.office.rentals;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalRestController {

    private RentalService rentalService;

    public RentalRestController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/customers/{customerId}/rentals")
    public void createRental(@RequestBody List<RentalDtoRequest> rentalDtoRequest,
                             @PathVariable Long customerId){
        rentalService.createRental(rentalDtoRequest, customerId);
    }

    @PostMapping("/rentals/{rentalId}/finish")
    public void finishRental(@PathVariable Long rentalId){
        rentalService.finishRental(rentalId);
    }
}
