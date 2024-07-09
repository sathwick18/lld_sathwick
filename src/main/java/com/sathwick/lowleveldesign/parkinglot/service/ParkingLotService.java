package com.sathwick.lowleveldesign.parkinglot.service;

import com.sathwick.lowleveldesign.parkinglot.service.custom_datatypes.ParkingSlotsCount;

public interface ParkingLotService {
    void addParkingLot(long parkingLotId, int numFloors, ParkingSlotsCount[] parkingSlotsCount);
    void addParkingLot(long parkingLotId, int numFloors, ParkingSlotsCount[] parkingSlotsCount, int numOfEntranceGates, int numOfExitGates);
}
