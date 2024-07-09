package com.maja.rental.office.customers;

import org.springframework.stereotype.Service;

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

    public CustomerDtoResponse getCustomerByPesel (Long pesel){
        Customer customer = customerRepository.findByPesel(pesel).get();
        return new CustomerDtoResponse(customer.getPesel(), customer.getFirstName(), customer.getLastName());
    }

}
