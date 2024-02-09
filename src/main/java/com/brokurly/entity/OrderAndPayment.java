package com.brokurly.entity;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderAndPayment {
    private String orderId;
    private String sellerId;
    private String custId;
    private String orderStat;
    private String orderDt;
    private int totalItemQty;
    private int totalPrice;
    private int totalDcAmt;
    private int orderAmt;
    private int shipFee;
    private String orderAddr;
    private String shipNo;
    private String payNo;
    private String payMthd;
    private String payStat;
    private Timestamp payReqDt;
    private Timestamp payConfDt;
    private int order_amt;
    private Integer cpnDcAmt;
    private Integer cardDcAmt;
    private Integer pointDcAmt;
    private int payAmt;

}