package com.sathwick.lowleveldesign.parkinglot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingSlot;
import com.sathwick.lowleveldesign.parkinglot.repository.ParkingSlotRepository;
import com.sathwick.lowleveldesign.parkinglot.service.ParkingSlotService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParkingSlotServiceImpl implements ParkingSlotService{

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Override
    public void addParkingSlot(ParkingSlot parkingSlot) {
        log.debug("Adding parking slot: {}", parkingSlot);
        parkingSlotRepository.save(parkingSlot);
    }

    @Override
    public void removeParkingSlot(long parkingSlotId) {
        log.debug("Removing parking slot: {}", parkingSlotId);
        parkingSlotRepository.deleteById(parkingSlotId);
    }

    @Override
    public void updateParkingSlot(ParkingSlot parkingSlot) {
        log.debug("Updating parking slot: {}", parkingSlot);
        if (!parkingSlotRepository.existsById(parkingSlot.getParkingSlotId())) {
            log.error("Parking slot not found");
            throw new RuntimeException("Parking slot not found");
        }
        parkingSlotRepository.save(parkingSlot);
    }
    
}

