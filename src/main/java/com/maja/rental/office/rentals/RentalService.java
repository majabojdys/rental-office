package com.maja.rental.office.rentals;

import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.customers.CustomerNotFoundException;
import com.maja.rental.office.customers.CustomerRepository;
import com.maja.rental.office.equipment.Equipment;
import com.maja.rental.office.equipment.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalService {

    private CustomerRepository customerRepository;
    private RentEquipmentService rentEquipmentService;

    public RentalService(CustomerRepository customerRepository, RentEquipmentService rentEquipmentService) {
        this.customerRepository = customerRepository;
        this.rentEquipmentService = rentEquipmentService;
    }

    public void createRental(List<RentalDtoRequest> rentalDtoRequest, Long customerId){
        Customer customer = customerRepository.findByPesel(customerId).orElseThrow(()-> new CustomerNotFoundException());
        rentEquipmentService.rentEquipmentAndAdjustQuantity(rentalDtoRequest, customer);
    }

    public void finishRental(Long rentalId){
        rentEquipmentService.finishRentalAndAdjustEquipmentQuantity(rentalId);
    }
}
