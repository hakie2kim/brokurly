package com.brokurly.entity;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {
    private int orderNo;
    private String orderId;
    private String itemId;
    private int itemQty;
    private int itemPrice;
}
