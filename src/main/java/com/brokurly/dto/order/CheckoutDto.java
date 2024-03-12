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
    private ReceiverDetailsResponseDto receiverDetails;
    // 주문 상품 목록
    private List<CustomerCartDto> customerCart;
    // 결제 금액
    private PaymentAmountCheckoutDto paymentAmount;
}
