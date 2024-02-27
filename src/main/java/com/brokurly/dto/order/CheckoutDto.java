package com.brokurly.dto.order;

import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.dto.payment.PaymentAmountCheckoutDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
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
    private List<CustomerCartDto> customerCart;
    // 결제 금액
    private PaymentAmountCheckoutDto paymentAmount;
}
