package com.maja.rental.office.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    List<Equipment> findAllByTypeAndSizeAndRentalOfficeId(EquipmentType type, EquipmentSize size, Long rentalOfficeId);
}
