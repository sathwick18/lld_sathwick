package com.sathwick.lowleveldesign.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sathwick.lowleveldesign.parkinglot", "com.sathwick.lowleveldesign.main"})
@EnableJpaRepositories(basePackages = "com.sathwick.lowleveldesign.parkinglot.repository")
@EntityScan(basePackages = "com.sathwick.lowleveldesign.parkinglot.domain")
public class LowleveldesignbysathwickApplication implements CommandLineRunner {

	@Autowired
    ParkingLotMain parkingLotMain;


	public static void main(String[] args) {
		SpringApplication.run(LowleveldesignbysathwickApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		parkingLotMain.test();
	}
}
