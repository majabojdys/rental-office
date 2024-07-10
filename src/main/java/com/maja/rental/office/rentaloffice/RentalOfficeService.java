package com.maja.rental.office.rentaloffice;

import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<GetRentalOfficeDtoResponse> getRentalOffices(){
        return rentalOfficeRepository.findAll().stream()
                .map(o -> new GetRentalOfficeDtoResponse(o.getName(),
                        o.getAddress().getCountryCode(),
                        o.getAddress().getCity(),
                        o.getAddress().getStreet(),
                        o.getAddress().getNumber()))
                .toList();
    }

    public GetRentalOfficeDtoResponse getRentalOfficeById(Long id){
        RentalOffice rentalOffice = rentalOfficeRepository.findById(id).orElseThrow(() -> new RentalOfficeNotFountException());
        return new GetRentalOfficeDtoResponse(rentalOffice.getName(),
                rentalOffice.getAddress().getCountryCode(),
                rentalOffice.getAddress().getCity(),
                rentalOffice.getAddress().getStreet(),
                rentalOffice.getAddress().getNumber());
    }

}
