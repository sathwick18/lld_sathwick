package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingSlotType;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingSlotId;
    private boolean isOccupied;
    @Embedded
    private Vehicle vehicle;
    private ParkingSlotType parkingSlotType;
    @ManyToOne
    @JoinColumn(name = "parking_floor_id")
    private ParkingFloor ParkingFloor;
}