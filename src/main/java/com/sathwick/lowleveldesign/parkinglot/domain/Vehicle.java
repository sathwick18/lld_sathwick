package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.VehicleType;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Vehicle {
    private String vehicleNumber;
    private VehicleType VehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        VehicleType = vehicleType;
    }
}
