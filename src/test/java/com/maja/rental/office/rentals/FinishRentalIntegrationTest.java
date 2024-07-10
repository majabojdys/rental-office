package com.maja.rental.office.rentals;

import com.maja.rental.office.IntegrationTest;
import com.maja.rental.office.customers.Customer;
import com.maja.rental.office.equipment.Equipment;
import com.maja.rental.office.equipment.EquipmentSize;
import com.maja.rental.office.equipment.EquipmentType;
import com.maja.rental.office.rentaloffice.RentalOffice;
import com.maja.rental.office.rentaloffice.RentalOfficeAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

public class FinishRentalIntegrationTest extends IntegrationTest {

    @Test
    public void finishRentalTest(){
        //given
        Customer customer = new Customer(123L, "Jan", "Kowalski");
        customerRepository.save(customer).getPesel();

        RentalOffice rentalOffice = new RentalOffice(
                new RentalOfficeAddress("PL", "Gliwice", "Wolnosci", 1), "biuro1");
        rentalOfficeRepository.save(rentalOffice).getRentalOfficeId();

        EquipmentType type = EquipmentType.SNOWBOARD;
        EquipmentSize size = EquipmentSize.M;

        Equipment equipment = new Equipment(rentalOffice, type, size, 10d, 4);
        equipmentRepository.save(equipment).getEquipmentId();

        RentalStock rentalStock = new RentalStock(2, equipment);
        Rental rental = new Rental(LocalDateTime.now(), null, customer, List.of(rentalStock));
        Long rentalId = rentalRepository.save(rental).getId();

        //when
        ResponseEntity<Void> response = restTemplate.postForEntity(getLocalhost() + "/rentals/" + rentalId + "/finish", null, Void.class);

        //then
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

        Rental finishedRental = rentalRepository.findAll().get(0);
        Assertions.assertEquals(customer, finishedRental.getCustomer());
        Assertions.assertTrue(finishedRental.getReturnedAt().isPresent());
        Assertions.assertEquals(equipment.getEquipmentId(), finishedRental.getRentalStocks().get(0).getEquipment().getEquipmentId());
        Assertions.assertEquals(6, finishedRental.getRentalStocks().get(0).getEquipment().getQuantity());
    }
}
