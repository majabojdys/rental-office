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
                equipmentDtoRequest.getPricePerDay());
        equipmentRepository.save(equipment);
    }

    public List<EquipmentDtoResponse> getEquipmentByTypeAndSizeAndRentalOfficeId(Long rentalOfficeId, EquipmentType type, EquipmentSize size){

       return equipmentRepository.findAllByTypeAndSizeAndRentalOfficeId(type, size, rentalOfficeId).stream()
               .map(e -> new EquipmentDtoResponse(e.getRentalOffice().getRentalOfficeId(),
                       e.getRentalOffice().getName(),
                       e.getType(),
                       e.getSize(),
                       e.getPricePerDay()))
               .toList();
    }


}
