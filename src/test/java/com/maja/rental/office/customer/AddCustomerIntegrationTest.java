package com.maja.rental.office.customer;

import com.maja.rental.office.IntegrationTest;
import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.customers.CustomerDtoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddCustomerIntegrationTest extends IntegrationTest{

    @Test
    public void testCustomerAddition(){
        //given
        Long pesel = 123L;
        String firstName = "Jan";
        String lastName = "Kowalski";
        CustomerDtoRequest customerRequest = new CustomerDtoRequest(pesel, firstName, lastName);

        //when
        ResponseEntity<Void> response = restTemplate.postForEntity(getLocalhost() + "/customers", customerRequest, Void.class);

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Customer customer = customerRepository.findByPesel(pesel).get();
        Assertions.assertEquals(pesel, customer.getPesel());
        Assertions.assertEquals(firstName, customer.getFirstName());
        Assertions.assertEquals(lastName, customer.getLastName());
    }
}
