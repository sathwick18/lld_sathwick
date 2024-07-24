package com.sathwick.lowleveldesign.parkinglot.domain;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ParkingFloor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingFloorId;
    private int floorNumber;
    @OneToMany(mappedBy = "parkingFloor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ParkingSlot> parkingSlots;
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;
}
