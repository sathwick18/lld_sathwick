package com.sathwick.lowleveldesign.parkinglot.domain.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "payment_id")
public class CardPayment {
    private String cardNumber;
    private String cardHolderName;
    private String transactionId;
}
