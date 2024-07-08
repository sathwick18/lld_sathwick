package com.sathwick.lowleveldesign.parkinglot.domain;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ParkingTicket {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long ticketId;
    @Embedded
    private Vehicle vehicle;
    @CreationTimestamp
    private Date entryTime;
}
