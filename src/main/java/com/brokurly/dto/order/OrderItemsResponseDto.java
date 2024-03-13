package com.brokurly.dto.order;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsResponseDto {
    private String orderId;
    private String itemId;
    private int itemQty;
    private int itemPrice;
}
