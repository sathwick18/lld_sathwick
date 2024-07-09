package com.sathwick.lowleveldesign.parkinglot.service;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingSlot;

public interface ParkingSlotService {
    void addParkingSlot(ParkingSlot parkingSlot);
    void removeParkingSlot(long parkingSlotId);
    void updateParkingSlot(ParkingSlot parkingSlot);
}
