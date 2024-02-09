package com.brokurly.entity;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String payNo;
    private String payMthd;
    private String payStat;
    private Timestamp payReqDt;
    private Timestamp payConfDt;
    private int order_amt;
    private int shipFee;
    private Integer cpnDcAmt;
    private Integer cardDcAmt;
    private Integer pointDcAmt;
    private int payAmt;
    private String orderId;
}