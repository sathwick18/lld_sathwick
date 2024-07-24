package com.sathwick.lowleveldesign.parkinglot.domain;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingSlotType;
import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private ParkingSlotType parkingSlotType;
    @ManyToOne
    @JoinColumn(name = "parking_floor_id")
    private ParkingFloor parkingFloor;
}