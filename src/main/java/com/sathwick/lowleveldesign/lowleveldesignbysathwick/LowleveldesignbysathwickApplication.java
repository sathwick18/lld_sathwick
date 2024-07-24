package com.sathwick.lowleveldesign.lowleveldesignbysathwick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sathwick.lowleveldesign.parkinglot.repository", "com.sathwick.lowleveldesign.parkinglot.service.impl"})
public class LowleveldesignbysathwickApplication implements CommandLineRunner {

	@Autowired
    ParkingLotMain parkingLotMain;


	public static void main(String[] args) {
		SpringApplication.run(LowleveldesignbysathwickApplication.class, args);

		parkingLotMain.test();

	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
