package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingGateType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ParkingGate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingGateId;
    private ParkingGateType parkingGateType;
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;
}
