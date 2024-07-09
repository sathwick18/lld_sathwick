package com.sathwick.lowleveldesign.parkinglot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingFloor;

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Long> {
    Optional<ParkingFloor> findByFloorNumber(int floorNumber);
} 