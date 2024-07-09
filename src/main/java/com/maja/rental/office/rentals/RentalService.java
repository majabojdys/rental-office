package com.maja.rental.office.rentals;

import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.customers.CustomerRepository;
import com.maja.rental.office.equipment.Equipment;
import com.maja.rental.office.equipment.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalService {

    private RentalRepository rentalRepository;
    private CustomerRepository customerRepository;
    private EquipmentRepository equipmentRepository;

    public RentalService(RentalRepository rentalRepository, CustomerRepository customerRepository, EquipmentRepository equipmentRepository) {
        this.rentalRepository = rentalRepository;
        this.customerRepository = customerRepository;
        this.equipmentRepository = equipmentRepository;
    }

    public void createRental(List<RentalDtoRequest> rentalDtoRequest, Long customerId){
        Customer customer = customerRepository.findByPesel(customerId).get();
        List<Equipment> equipments = rentalDtoRequest.stream()
                .map(request -> equipmentRepository.findByTypeAndSizeAndRentalOfficeId(request.getType(),
                            request.getSize(),
                            request.getRentalOfficeId()).get())
                .toList();
        Rental rental = new Rental(LocalDateTime.now(), null, customer, equipments);
        rentalRepository.save(rental);
    }
}
