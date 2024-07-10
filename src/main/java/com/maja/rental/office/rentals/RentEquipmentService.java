package com.maja.rental.office.rentals;

import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.equipment.Equipment;
import com.maja.rental.office.equipment.EquipmentNotFoundException;
import com.maja.rental.office.equipment.EquipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentEquipmentService {

    private RentalRepository rentalRepository;
    private EquipmentRepository equipmentRepository;

    public RentEquipmentService(RentalRepository rentalRepository, EquipmentRepository equipmentRepository) {
        this.rentalRepository = rentalRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Transactional
    public void rentEquipmentAndAdjustQuantity(List<RentalDtoRequest> rentalDtoRequest, Customer customer){
        List<RentalStock> rentalStocks = rentalDtoRequest.stream()
                .map(request -> {
                    Equipment equipment = equipmentRepository.findByTypeAndSizeAndRentalOfficeId(request.getType(),
                            request.getSize(),
                            request.getRentalOfficeId()).orElseThrow(()-> new EquipmentNotFoundException("nie znaleziono sprzętu:" + request.getType() + "o rozmiarze:" + request.getSize() + "w lokalizacji:" + request.getRentalOfficeId()));
                    if(equipment.getQuantity() >= request.getQuantity()){
                        equipment.setQuantity(equipment.getQuantity() - request.getQuantity());
                    } else {
                        throw new RuntimeException();
                    }
                    return new RentalStock(request.getQuantity(), equipment);
                })
                .toList();
        Rental rental = new Rental(LocalDateTime.now(), null, customer, rentalStocks);
        rentalRepository.save(rental);
    }

    @Transactional
    public void finishRentalAndAdjustEquipmentQuantity(Long rentalId){
        Rental rental = rentalRepository.findById(rentalId).orElseThrow(() -> new RentalNotFoundException());
        rental.setReturnedAt(LocalDateTime.now());
        rental.getRentalStocks().forEach(rentalStock -> {
            Equipment equipment = rentalStock.getEquipment();
            equipment.setQuantity(equipment.getQuantity() + rentalStock.getQuantity());
        });
        rentalRepository.save(rental);
    }
}
