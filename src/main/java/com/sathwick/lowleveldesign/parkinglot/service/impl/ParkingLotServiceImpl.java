package com.sathwick.lowleveldesign.parkinglot.service.impl;

import com.sathwick.lowleveldesign.parkinglot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sathwick.lowleveldesign.parkinglot.domain.ParkingFloor;
import com.sathwick.lowleveldesign.parkinglot.domain.ParkingLot;
import com.sathwick.lowleveldesign.parkinglot.domain.ParkingSlot;
import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingGateType;
import com.sathwick.lowleveldesign.parkinglot.domain.ParkingFloor.ParkingFloorBuilder;
import com.sathwick.lowleveldesign.parkinglot.domain.ParkingGate;
import com.sathwick.lowleveldesign.parkinglot.service.ParkingFloorService;
import com.sathwick.lowleveldesign.parkinglot.service.ParkingGateService;
import com.sathwick.lowleveldesign.parkinglot.service.ParkingLotService;
import com.sathwick.lowleveldesign.parkinglot.service.custom_datatypes.ParkingSlotsCount;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingFloorService parkingFloorService;
    private final ParkingGateService parkingGateService;
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotServiceImpl(ParkingFloorService parkingFloorService, ParkingGateService parkingGateService, ParkingLotRepository parkingLotRepository) {
        this.parkingFloorService = parkingFloorService;
        this.parkingGateService = parkingGateService;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public void addParkingLot(long parkingLotId, int numFloors, ParkingSlotsCount[] parkingSlotsCount) {
        log.info("Adding parking lot: {}", parkingLotId);
        parkingLotRepository.save(ParkingLot.builder().parkingLotId(parkingLotId).build());
        try {
            for (int i = 1; i <= numFloors; i++) {
                log.info("Adding parking floor: {}", i);
                ParkingFloorBuilder parkingFloorBuilder = ParkingFloor.builder();
                parkingFloorBuilder.parkingLot(ParkingLot.builder().parkingLotId(parkingLotId).build());
                parkingFloorBuilder.floorNumber(i);
                parkingFloorService.addParkingFloor(parkingFloorBuilder.build());

                ParkingFloor parkingFloor = parkingFloorService.getParkingFloorByFloorNumber(i);
                List<ParkingSlot> parkingSlots = new ArrayList<>();
                for (int j = 0; j < parkingSlotsCount.length; j++) {
                    for (int k = 1; k <= parkingSlotsCount[j].getNumOfSlots(); k++) {
                        parkingSlots.add(ParkingSlot.builder().parkingFloor(parkingFloor).parkingSlotType(parkingSlotsCount[j].getParkingSlotType()).build());
                    }
                }
                parkingFloor.setParkingSlots(parkingSlots);
                parkingFloorService.updateParkingFloor(parkingFloor);
            }
        }
        catch (DataIntegrityViolationException e){
            log.error("Failed to create ParkingLot: {}", parkingLotId);
            log.error(e.getMessage());
        }
        log.info("Created ParkingLot Successfully: {}", parkingLotId);
    }

    @Override
    public void addParkingLot(long parkingLotId, int numFloors, ParkingSlotsCount[] parkingSlotsCount, int numOfEntranceGates,
            int numOfExitGates) {
        addParkingLot(parkingLotId, numFloors, parkingSlotsCount);
        for(int i = 1; i <= numOfEntranceGates; i++) {
            parkingGateService.addParkingGate(ParkingGate.builder().parkingGateType(ParkingGateType.ENTRANCE).parkingLot(ParkingLot.builder().parkingLotId(parkingLotId).build()).build());
        }
        for(int i = 1; i <= numOfExitGates; i++) {
            parkingGateService.addParkingGate(ParkingGate.builder().parkingGateType(ParkingGateType.EXIT).parkingLot(ParkingLot.builder().parkingLotId(parkingLotId).build()).build());
        }
        log.info("Created ParkingLot Successfully with Entrance and Exit Gates: {}", parkingLotId);
    }
}
