package com.brokurly.entity.order;

import com.brokurly.dto.cart.CustomerCartDto;
import lombok.*;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemList {
    private String orderId;
    private String itemId;
    private int itemQty;
    private int itemPrice;

    public void changeOrderItemList(CustomerCartDto cartDto, String orderId) {
        this.orderId = orderId;
        this.itemId = cartDto.getItemId();
        this.itemQty = cartDto.getItemCnt();
        this.itemPrice = cartDto.getPrice();
    }
}
