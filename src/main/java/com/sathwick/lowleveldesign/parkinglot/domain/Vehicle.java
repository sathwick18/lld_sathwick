package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.VehicleType;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class Vehicle {
    private String vehicleNumber;
    private VehicleType VehicleType;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        VehicleType = vehicleType;
    }
}
