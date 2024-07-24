package com.sathwick.lowleveldesign.parkinglot.domain;

import java.util.List;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingFloor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parkingFloorId;
    @UniqueElements
    private int floorNumber;
    @OneToMany(mappedBy = "parking_floor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ParkingSlot> parkingSlots;
    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;
}
