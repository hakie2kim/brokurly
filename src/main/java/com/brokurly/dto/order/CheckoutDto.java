package com.brokurly.dto.order;

import com.brokurly.dto.cart.CartDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class CheckoutDto {
    private String rcvName;
    private String telNo;
    private String rcvPlace;
    private String enterMthd;
    private String placeExp;
    private String msgTime;

    private List<CartDto> customerCart;
}
