package com.sathwick.lowleveldesign.lowleveldesignbysathwick;

import com.sathwick.lowleveldesign.parkinglot.domain.enums.ParkingSlotType;
import com.sathwick.lowleveldesign.parkinglot.service.ParkingLotService;
import com.sathwick.lowleveldesign.parkinglot.service.custom_datatypes.ParkingSlotsCount;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
@ComponentScan(basePackages = "com.sathwick.lowleveldesign.parkinglot")
public class ParkingLotMain {

    private ParkingLotService parkingLotService;

    public ParkingLotMain(ParkingLotService parkingLotService){
        this.parkingLotService = parkingLotService;
    }

    public void test(){
        ParkingSlotsCount[] parkingSlotsCount = {
                new ParkingSlotsCount(ParkingSlotType.SMALL, 100),
                new ParkingSlotsCount(ParkingSlotType.LARGE, 400),
                new ParkingSlotsCount(ParkingSlotType.EXTRA_LARGE, 50)
        };
        parkingLotService.addParkingLot(1, 4, parkingSlotsCount);
    }
}
