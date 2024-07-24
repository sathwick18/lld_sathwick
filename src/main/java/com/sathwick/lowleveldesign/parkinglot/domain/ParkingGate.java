package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingGateType;

import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private ParkingGateType parkingGateType;
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;
}
