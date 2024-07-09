package com.sathwick.lowleveldesign.parkinglot.service;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingGate;

public interface ParkingGateService {
    void addParkingGate(ParkingGate parkingGate);
    void removeParkingGateById(long parkingGateId);
}
