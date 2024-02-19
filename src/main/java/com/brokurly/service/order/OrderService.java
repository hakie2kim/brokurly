package com.brokurly.service.order;

import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.ReceiverDetailsDto;
import com.brokurly.service.cart.CartService;
import com.brokurly.service.order.ReceiverDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CartService cartService;
    private final ReceiverDetailsService receiverDetailsService;

    public CheckoutDto getCheckoutInfo() {
        // 배송지 정보 가져오는 서비스 필요
        ReceiverDetailsDto receiverDetailsDto = receiverDetailsService.findReceiverDetails("추가 예정");


        return null;
    }
}
