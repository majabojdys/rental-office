package com.maja.rental.office.rentals;

import com.maja.rental.office.IntegrationTest;
import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.equipment.Equipment;
import com.maja.rental.office.equipment.EquipmentRepository;
import com.maja.rental.office.equipment.EquipmentSize;
import com.maja.rental.office.equipment.EquipmentType;
import com.maja.rental.office.rentaloffice.RentalOffice;
import com.maja.rental.office.rentaloffice.RentalOfficeAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CreateRentalIntegrationTest extends IntegrationTest {

    @Test
    public void createRentalTest(){
        //given
        Customer customer = new Customer(123L, "Jan", "Kowalski");
        Long customerId = customerRepository.save(customer).getPesel();

        RentalOffice rentalOffice = new RentalOffice(
                new RentalOfficeAddress("PL", "Gliwice", "Wolnosci", 1), "biuro1");
        Long rentalOfficeId = rentalOfficeRepository.save(rentalOffice).getRentalOfficeId();

        EquipmentType type = EquipmentType.SNOWBOARD;
        EquipmentSize size = EquipmentSize.M;
        Integer quantity = 1;

        Equipment equipment = new Equipment(rentalOffice, type, size, 10d, quantity);
        equipmentRepository.save(equipment).getEquipmentId();

        List<RentalDtoRequest> request = List.of(new RentalDtoRequest(type, size, quantity, rentalOfficeId));

        //when
        ResponseEntity<Void> response = restTemplate.postForEntity(getLocalhost() + "/customers/" + customerId + "/rentals", request, Void.class);

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Rental rental = rentalRepository.findAll().get(0);
        Assertions.assertEquals(customer, rental.getCustomer());
        Assertions.assertEquals(List.of(equipment), rental.getEquipments());
    }
}
