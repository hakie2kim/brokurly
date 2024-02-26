package com.brokurly.dto.order;

import com.brokurly.dto.cart.CartDto;
import com.brokurly.dto.payment.PaymentAmountCheckoutDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class CheckoutDto {
    // 배송 요청사항 정보
    private String rcvName;
    private String telNo;
    private String rcvPlace;
    private String enterMthd;
    private String placeExp;
    private String msgTime;

    // 주문 상품 목록
    private List<CartDto> customerCart;
    // 결제 금액
    private PaymentAmountCheckoutDto paymentAmount;
}
