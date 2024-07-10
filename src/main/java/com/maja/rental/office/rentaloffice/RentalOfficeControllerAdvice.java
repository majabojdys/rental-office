package com.maja.rental.office.rentaloffice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RentalOfficeControllerAdvice {

    @ExceptionHandler(RentalOfficeNotFountException.class)
    public ResponseEntity<String> handleRentalOfficeNotFoundException(RentalOfficeNotFountException e){
        return new ResponseEntity<>("Taka wypżyczalnia nie istnieje", HttpStatus.NOT_FOUND);
    }

}
