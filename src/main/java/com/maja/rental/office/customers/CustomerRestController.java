package com.maja.rental.office.customers;

import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody CustomerDtoRequest customerDtoRequest){
        customerService.addCustomer(customerDtoRequest);
    }

    @GetMapping("/customers/{pesel}")
    public CustomerDtoResponse getCustomerByPesel(@PathVariable Long pesel){
        return customerService.getCustomerByPesel(pesel);
    }
}
