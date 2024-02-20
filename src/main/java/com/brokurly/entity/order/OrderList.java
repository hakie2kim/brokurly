package com.brokurly.entity.order;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class OrderList {
    private int orderNo;
    private String orderId;
    private String itemId;
    private int itemQty;
    private int itemPrice;
}
