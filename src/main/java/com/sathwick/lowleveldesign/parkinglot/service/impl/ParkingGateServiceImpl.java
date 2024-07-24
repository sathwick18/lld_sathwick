package com.sathwick.lowleveldesign.parkinglot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingGate;
import com.sathwick.lowleveldesign.parkinglot.repository.ParkingGateRepository;
import com.sathwick.lowleveldesign.parkinglot.service.ParkingGateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ParkingGateServiceImpl implements ParkingGateService{
    
    private final ParkingGateRepository parkingGateRepository;

    public ParkingGateServiceImpl(ParkingGateRepository parkingGateRepository) {
        this.parkingGateRepository = parkingGateRepository;
    }

    @Override
    public void addParkingGate(ParkingGate parkingGate) {
        try {
            parkingGateRepository.save(parkingGate);
        } catch (Exception e) {
            log.error("Failed to save parking gate: {}", parkingGate, e);
            throw e;
        }
    }

    @Override
    public void removeParkingGateById(long parkingGateId) {
        log.debug("Removing parking gate: {}", parkingGateId);
        parkingGateRepository.deleteById(parkingGateId);
    }

}

