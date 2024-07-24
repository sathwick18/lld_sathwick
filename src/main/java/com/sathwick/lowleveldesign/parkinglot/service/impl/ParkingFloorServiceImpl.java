package com.sathwick.lowleveldesign.parkinglot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingFloor;
import com.sathwick.lowleveldesign.parkinglot.repository.ParkingFloorRepository;
import com.sathwick.lowleveldesign.parkinglot.service.ParkingFloorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ParkingFloorServiceImpl implements ParkingFloorService {
    @Autowired
    private ParkingFloorRepository parkingFloorRepository;

    @Override
    public void addParkingFloor(ParkingFloor parkingFloor) {
        log.info("Adding parking floor to database: {}", parkingFloor);
        parkingFloorRepository.save(parkingFloor);
    }

    @Override
    public void removeParkingFloorById(Long id) {
        log.info("Removing parking floor with id from database: {}", id);
        parkingFloorRepository.deleteById(id);
    }

    @Override
    public void updateParkingFloor(ParkingFloor parkingFloor) {
        log.info("Updating parking floor in database: {}", parkingFloor);
        parkingFloorRepository.save(parkingFloor);
    }

    /**
     * Retrieves a {@link ParkingFloor} by its floor number.
     *
     * @param floorNumber the floor number of the parking floor to retrieve
     * @return the parking floor with the given floor number, or
     *         {@code null} if no such parking floor exists
     * @throws IllegalArgumentException if no parking floor with the given
     *         floor number exists
     */
    @Override
    public ParkingFloor getParkingFloorByFloorNumber(int floorNumber) {
        log.info("Getting parking floor with floor number: {}", floorNumber);
        ParkingFloor parkingFloor = parkingFloorRepository.findByFloorNumber(floorNumber)
                .orElseThrow(() -> {
                    String message = "Parking floor with floor number " + floorNumber + " not found";
                    log.error(message);
                    return new IllegalArgumentException(message);
                });
        log.info("Found parking floor: {}", parkingFloor);
        return parkingFloor;
    }
}
