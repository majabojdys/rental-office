package com.maja.rental.office;

import com.maja.rental.office.customers.CustomerRepository;
import com.maja.rental.office.equipment.EquipmentRepository;
import com.maja.rental.office.rentaloffice.RentalOfficeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public abstract class IntegrationTest {

    @Autowired
    protected RentalOfficeRepository rentalOfficeRepository;

    @Autowired
    protected EquipmentRepository equipmentRepository;

    @Autowired
    protected TestRestTemplate restTemplate;

    @LocalServerPort
    protected int randomServerPort;

    @Autowired
    protected CustomerRepository customerRepository;

    @BeforeEach
    public void truncateDb(){
        equipmentRepository.deleteAll();
        rentalOfficeRepository.deleteAll();
        customerRepository.deleteAll();
    }

    protected String getLocalhost(){
        return "http://localhost:" + randomServerPort;
    }
}
