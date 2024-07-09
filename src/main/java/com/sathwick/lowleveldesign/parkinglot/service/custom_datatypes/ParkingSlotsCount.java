package com.sathwick.lowleveldesign.parkinglot.service.custom_datatypes;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingSlotType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ParkingSlotsCount {
    private final ParkingSlotType parkingSlotType;
    private final int numOfSlots;
}
