package com.brokurly.entity.payment;

import lombok.*;

import java.sql.Timestamp;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class PaymentDetails {
    private String payNo;
    private String payMthd;
    private String payStat;
    private Timestamp payReqDt;
    private Timestamp payConfDt;
    private String orderId;

    private PaymentAmount paymentAmount;
}