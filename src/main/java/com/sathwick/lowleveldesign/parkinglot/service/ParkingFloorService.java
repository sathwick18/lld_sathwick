package com.sathwick.lowleveldesign.parkinglot.service;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingFloor;

public interface ParkingFloorService {
    void addParkingFloor(ParkingFloor parkingFloor);
    void removeParkingFloorById(Long id);
    void updateParkingFloor(ParkingFloor parkingFloor);
    ParkingFloor getParkingFloorByFloorNumber(int floorNumber);
}
