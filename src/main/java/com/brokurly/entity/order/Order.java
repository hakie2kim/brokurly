package com.brokurly.entity.order;


import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.OrderResponseDto;
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
    private String shipLocaId;
    private String shipNo;

    public void changeOrder(CheckoutDto dto, String orderId, String custId, String shipLocaId) {
        this.orderId = orderId;
        this.custId = custId;
        this.totalItemQty = dto.getCustomerCart().stream()
                .mapToInt(CustomerCartDto::getItemCnt)
                .sum();
        this.totalPrice = dto.getPaymentAmount().getItemAmt();
        this.totalDcAmt = dto.getPaymentAmount().getItemDcAmt();
        this.orderAmt = dto.getPaymentAmount().getOrderAmt();
        this.shipFee = dto.getPaymentAmount().getShipFee();
        this.shipLocaId = shipLocaId;
        this.shipNo = "1111";
    }

    public OrderResponseDto toResponseDto() {
        return OrderResponseDto.builder()
                .orderId(orderId)
                .custId(custId)
                .orderDt(orderDt)
                .totalItemQty(totalItemQty)
                .totalPrice(totalPrice)
                .totalDcAmt(totalDcAmt)
                .orderAmt(orderAmt)
                .shipFee(shipFee)
                .shipLocaId(shipLocaId)
                .shipNo(shipNo)
                .build();
    }
}
