package com.maja.rental.office.equipment;

import com.maja.rental.office.rentaloffice.RentalOffice;
import com.maja.rental.office.rentaloffice.RentalOfficeAddress;
import com.maja.rental.office.rentaloffice.RentalOfficeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

public class EquipmentServiceTest {

    private RentalOfficeRepository rentalOfficeRepository = Mockito.mock(RentalOfficeRepository.class);
    private EquipmentRepository equipmentRepository = Mockito.mock(EquipmentRepository.class);
    EquipmentService equipmentService = new EquipmentService(rentalOfficeRepository, equipmentRepository);

    @Test
    public void testMappingEquipmentAddition(){
        //given
        EquipmentType type = EquipmentType.SKIS;
        EquipmentSize size = EquipmentSize.M;
        Double pricePerDay = 15.00;
        RentalOfficeAddress rentalOfficeAddress = new RentalOfficeAddress("Pl", "Warszawa", "Wolności",28);
        RentalOffice rentalOffice = new RentalOffice(rentalOfficeAddress, "biuro8");
        EquipmentDtoRequest equipmentDtoRequest = new EquipmentDtoRequest(type, size, pricePerDay);
        Mockito.when(rentalOfficeRepository.findById(1L)).thenReturn(Optional.of(rentalOffice));

        //when
        equipmentService.addEquipment(equipmentDtoRequest, 1L);

        //then
        Equipment equipment = new Equipment(rentalOffice, type, size, pricePerDay);
        Mockito.verify(equipmentRepository).save(equipment);

    }


    @Test
    public void testMappingEquipmentGetting(){
        //given
        EquipmentType type = EquipmentType.SKIS;
        EquipmentSize size = EquipmentSize.M;
        Double pricePerDay = 15.00;
        RentalOfficeAddress rentalOfficeAddress = new RentalOfficeAddress("Pl", "Warszawa", "Wolności",28);
        RentalOffice rentalOffice = new RentalOffice(rentalOfficeAddress, "biuro8");
        Equipment equipment = new Equipment(rentalOffice, type, size, pricePerDay);
        Mockito.when(equipmentRepository.findAllByTypeAndSizeAndRentalOfficeId(type, size, 1L)).thenReturn(List.of(equipment));

        //when
        List<EquipmentDtoResponse> responses = equipmentService.getEquipmentByTypeAndSizeAndRentalOfficeId(1L, type, size);

        //then
        Assertions.assertEquals(type, responses.get(0).getType());
        Assertions.assertEquals(size, responses.get(0).getSize());
        Assertions.assertEquals(pricePerDay, responses.get(0).getPricePerDay());
        Assertions.assertEquals("biuro8", responses.get(0).getRentalOfficeName());
    }

}
