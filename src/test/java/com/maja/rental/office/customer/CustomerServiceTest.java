package com.maja.rental.office.customer;

import com.maja.rental.office.customers.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class CustomerServiceTest {

    CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    CustomerService customerService = new CustomerService(customerRepository);

    @Test
    public void testMappingCustomerAddition(){
        //given
        Long pesel = 123L;
        String firstName = "Jan";
        String lastName = "Kowalski";
        CustomerDtoRequest customerDtoRequest = new CustomerDtoRequest(pesel, firstName, lastName);

        //when
        customerService.addCustomer(customerDtoRequest);

        //then
        Customer customer = new Customer(pesel, firstName, lastName);
        Mockito.verify(customerRepository).save(customer);
    }

    @Test
    public void testMappingCustomerGetting(){
        //given
        Long pesel = 123L;
        String firstName = "Jan";
        String lastName = "Kowalski";
        Customer customer = new Customer(pesel, firstName, lastName);
        Mockito.when(customerRepository.findByPesel(pesel)).thenReturn(Optional.of(customer));

        //when
        CustomerDtoResponse response = customerService.getCustomerByPesel(pesel);

        //then
        Assertions.assertEquals(pesel, response.getPesel());
        Assertions.assertEquals(firstName, response.getFirstName());
        Assertions.assertEquals(lastName, response.getLastName());

    }

}
