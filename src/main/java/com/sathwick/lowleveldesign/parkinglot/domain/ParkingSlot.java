package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingSlotType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ParkingSlot {
    @Id
    private long parkingSlotId;
    private boolean isOccupied;
    private Vehicle vehicle;
    private ParkingSlotType parkingSlotType;
    
    public void parkVehicle(Vehicle vehicle){
        if(isOccupied){
            throw new RuntimeException("Parking slot is already occupied");
        }
        isOccupied = true;
        this.vehicle = vehicle;
    }

    public void unparkVehicle(){
        isOccupied = false;
        vehicle = null;
    }
}