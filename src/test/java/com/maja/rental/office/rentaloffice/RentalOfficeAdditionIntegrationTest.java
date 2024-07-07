package com.maja.rental.office.rentaloffice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RentalOfficeAdditionIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RentalOfficeRepository rentalOfficeRepository;

    @Test
    public void testAdditionRentalOffice() throws Exception {
        //given
        String name = "biuro1";
        String countryCode = "PL";
        String city = "Gliwice";
        String street = "Kowalska";
        Integer number = 23;
        AddRentalOfficeDtoRequest request = new AddRentalOfficeDtoRequest(name, countryCode, city, street, number);

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/rental-offices")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());

        //then
        RentalOffice rentalOffice = rentalOfficeRepository.findAll().get(0);
        Assertions.assertEquals(name, rentalOffice.getName());
        Assertions.assertEquals(countryCode, rentalOffice.getAddress().getCountryCode());
        Assertions.assertEquals(city, rentalOffice.getAddress().getCity());
        Assertions.assertEquals(street, rentalOffice.getAddress().getStreet());
        Assertions.assertEquals(number, rentalOffice.getAddress().getNumber());
    }

}
