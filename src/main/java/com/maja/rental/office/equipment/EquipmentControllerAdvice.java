package com.maja.rental.office.equipment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EquipmentControllerAdvice {

    @ExceptionHandler(EquipmentNotFoundException.class)
        public ResponseEntity<String> handleEquipmentNotFoundException(EquipmentNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
