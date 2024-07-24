package com.sathwick.lowleveldesign.parkinglot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingFloor;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingFloorRepository extends JpaRepository<ParkingFloor, Long> {
    Optional<ParkingFloor> findByFloorNumber(int floorNumber);
} 