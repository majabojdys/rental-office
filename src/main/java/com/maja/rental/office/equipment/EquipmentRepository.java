package com.maja.rental.office.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    Optional<Equipment> findByTypeAndSizeAndRentalOfficeId(EquipmentType type, EquipmentSize size, Long rentalOfficeId);
}
