package com.maja.rental.office.customer;

import com.maja.rental.office.customers.*;
import com.maja.rental.office.equipment.Equipment;
import com.maja.rental.office.equipment.EquipmentSize;
import com.maja.rental.office.equipment.EquipmentType;
import com.maja.rental.office.rentals.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.time.LocalDateTime;
import java.util.List;
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

        Equipment equipment = new Equipment(null, EquipmentType.SNOWBOARD, EquipmentSize.M, 5d, 1);
        Equipment equipment2 = new Equipment(null, EquipmentType.SKIS, EquipmentSize.M, 10d, 1);

        Customer customer = new Customer(pesel, firstName, lastName);
        Rental rental = new Rental(LocalDateTime.now().minusDays(2), null, customer, List.of(equipment, equipment2));
        customer.setRentals(List.of(rental));

        Mockito.when(customerRepository.findByPesel(pesel)).thenReturn(Optional.of(customer));

        //when
        CustomerDtoResponse response = customerService.getCustomerByPesel(pesel);

        //then
        Assertions.assertEquals(pesel, response.getPesel());
        Assertions.assertEquals(firstName, response.getFirstName());
        Assertions.assertEquals(lastName, response.getLastName());
        Assertions.assertEquals(30d, response.getCharge());
    }

}
