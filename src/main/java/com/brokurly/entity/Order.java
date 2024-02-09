package com.brokurly.entity;


import lombok.*;

@Getter
//@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Order {
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

}
