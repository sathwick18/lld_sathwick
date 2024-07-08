package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.VehicleType;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Embeddable
public class Vehicle {
    private String vehicleNumber;
    private VehicleType VehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        VehicleType = vehicleType;
    }
}
