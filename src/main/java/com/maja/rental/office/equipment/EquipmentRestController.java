package com.maja.rental.office.equipment;

import com.maja.rental.office.rentaloffice.RentalOffice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipmentRestController {

    private EquipmentService equipmentService;

    public EquipmentRestController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @PostMapping("/rental-offices/{rentalOfficeId}/equipments")
    public void addEquipment(@RequestBody EquipmentDtoRequest equipmentDtoRequest,
                             @PathVariable Long rentalOfficeId){
        equipmentService.addEquipment(equipmentDtoRequest, rentalOfficeId);
    }


    @GetMapping("/rental-offices/{rentalOfficeId}/equipments")
    public List<EquipmentDtoResponse> findEquipmentByTypeAndSize (@PathVariable Long rentalOfficeId,
                                                                  @RequestParam EquipmentType type,
                                                                  @RequestParam EquipmentSize size){
        return equipmentService.getEquipmentByTypeAndSizeAndRentalOfficeId(rentalOfficeId, type, size);
    }
}
