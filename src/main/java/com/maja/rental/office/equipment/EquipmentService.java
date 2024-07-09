package com.maja.rental.office.equipment;

import com.maja.rental.office.rentaloffice.RentalOffice;
import com.maja.rental.office.rentaloffice.RentalOfficeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private EquipmentRepository equipmentRepository;
    private RentalOfficeRepository rentalOfficeRepository;


    public EquipmentService(RentalOfficeRepository rentalOfficeRepository, EquipmentRepository equipmentRepository) {
        this.rentalOfficeRepository = rentalOfficeRepository;
        this.equipmentRepository = equipmentRepository;
    }

    public void addEquipment(EquipmentDtoRequest equipmentDtoRequest, Long rentalOfficeId){
        RentalOffice rentalOffice = rentalOfficeRepository.findById(rentalOfficeId).get();
        Equipment equipment = new Equipment(rentalOffice,
                equipmentDtoRequest.getType(),
                equipmentDtoRequest.getSize(),
                equipmentDtoRequest.getPricePerDay(),
                equipmentDtoRequest.getQuantity());
        equipmentRepository.save(equipment);
    }

    public EquipmentDtoResponse getEquipmentByTypeAndSizeAndRentalOfficeId(Long rentalOfficeId, EquipmentType type, EquipmentSize size){
        Equipment equipment = equipmentRepository.findByTypeAndSizeAndRentalOfficeId(type, size, rentalOfficeId).get();
        return new EquipmentDtoResponse(equipment.getRentalOffice().getRentalOfficeId(),
                equipment.getRentalOffice().getName(),
                equipment.getType(),
                equipment.getSize(),
                equipment.getPricePerDay(),
                equipment.getQuantity());
    }
}