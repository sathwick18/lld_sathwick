package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingSlotType;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Setter
@Getter
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parkingSlotId;
    private boolean isOccupied;
    @Embedded
    private Vehicle vehicle;
    private ParkingSlotType parkingSlotType;
    @ManyToOne
    @JoinColumn(name = "parking_floor_id")
    private ParkingFloor ParkingFloor;
}