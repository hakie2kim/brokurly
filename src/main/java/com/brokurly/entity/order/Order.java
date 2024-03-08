package com.brokurly.entity.order;


import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.dto.order.CheckoutDto;
import lombok.*;

@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
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

    public void changeOrder(CheckoutDto dto, String orderId, String custId) {
        this.orderId = orderId;
        this.custId = custId;
        this.totalItemQty = dto.getCustomerCart().stream()
                .mapToInt(CustomerCartDto::getItemCnt)
                .sum();
        this.totalPrice = dto.getPaymentAmount().getItemAmt();
        this.totalDcAmt = dto.getPaymentAmount().getItemDcAmt();
        this.orderAmt = dto.getPaymentAmount().getOrderAmt();
        this.shipFee = dto.getPaymentAmount().getShipFee();
        this.shipNo = "1111";
    }
}
