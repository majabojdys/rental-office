package com.maja.rental.office.customer;

import com.maja.rental.office.IntegrationTest;
import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.customers.CustomerDtoRequest;
import com.maja.rental.office.customers.CustomerDtoResponse;
import com.maja.rental.office.rentaloffice.GetRentalOfficeDtoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetCustomerIntegrationTest extends IntegrationTest {

    @Test
    public void GetCustomerIntegrationTest(){
        //given
        Long pesel = 123L;
        String firstName = "Jan";
        String lastName = "Kowalski";
        Customer customer = new Customer(pesel, firstName, lastName);
        customerRepository.save(customer);

        //when
        ResponseEntity<CustomerDtoResponse> response = restTemplate.getForEntity(getLocalhost() + "/customers/" + pesel, CustomerDtoResponse.class);

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Assertions.assertEquals(pesel, response.getBody().getPesel());
        Assertions.assertEquals(firstName, response.getBody().getFirstName());
        Assertions.assertEquals(lastName, response.getBody().getLastName());
    }
}
