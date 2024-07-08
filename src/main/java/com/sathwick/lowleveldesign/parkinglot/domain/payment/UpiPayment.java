package com.sathwick.lowleveldesign.parkinglot.domain.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "payment_id")
public class UpiPayment extends Payment{
    private String upiId;
    private String upiProvider;
    private String upiTransactionId;
}
