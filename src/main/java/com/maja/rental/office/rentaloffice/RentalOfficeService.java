package com.maja.rental.office.rentaloffice;

import org.springframework.stereotype.Service;

@Service
public class RentalOfficeService {

    private RentalOfficeRepository rentalOfficeRepository;

    public RentalOfficeService(RentalOfficeRepository rentalOfficeRepository) {
        this.rentalOfficeRepository = rentalOfficeRepository;
    }

    public void addRentalOffice(AddRentalOfficeDtoRequest addRentalOfficeDtoRequest) {
        RentalOfficeAddress address = new RentalOfficeAddress(addRentalOfficeDtoRequest.getCountryCode(),
                addRentalOfficeDtoRequest.getCity(),
                addRentalOfficeDtoRequest.getStreet(),
                addRentalOfficeDtoRequest.getNumber());
        RentalOffice rentalOffice = new RentalOffice(address, addRentalOfficeDtoRequest.getName());
        rentalOfficeRepository.save(rentalOffice);
    }
}
