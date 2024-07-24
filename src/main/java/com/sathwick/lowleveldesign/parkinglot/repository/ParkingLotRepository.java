package com.sathwick.lowleveldesign.parkinglot.repository;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
}
