package com.maja.rental.office.customers;

import com.maja.rental.office.rentals.Rental;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(CustomerDtoRequest customerDtoRequest){
        Customer customer = new Customer(customerDtoRequest.getPesel(), customerDtoRequest.getFirstName(), customerDtoRequest.getLastName());
        customerRepository.save(customer);
    }

    public CustomerDtoResponse getCustomerByPesel(Long pesel){
        Customer customer = customerRepository.findByPesel(pesel).get();
        Optional<Rental> notReturnedRental = customer.getRentals().stream()
                .filter(r -> r.getReturnedAt().equals(Optional.empty()))
                .findFirst();

        double charge = 0;
        if(notReturnedRental.isPresent()){
            charge = notReturnedRental.get().getEquipments().stream()
                    .mapToDouble(e -> e.getPricePerDay() * Math.abs(Duration.between(LocalDateTime.now(), notReturnedRental.get().getRentedAt()).toDays()))
                    .sum();
        }
        return new CustomerDtoResponse(customer.getPesel(), customer.getFirstName(), customer.getLastName(), charge);
    }

}
