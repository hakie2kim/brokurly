package com.brokurly.service.order;

import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.ReceiverDetailsResponseDto;
import com.brokurly.entity.payment.PaymentAmount;
import com.brokurly.service.cart.CustomerCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerCartService cartService;
    private final ReceiverDetailsService receiverDetailsService;

    public CheckoutDto getCheckoutInfo(String shipLocaId, String custId) {
        List<CustomerCartDto> cartList = cartService.getCartList(custId);
        ReceiverDetailsResponseDto receiverDetails = receiverDetailsService.findReceiverDetails(shipLocaId);

        if (cartList == null)
            throw new IllegalStateException("주문을 위해서는 반드시 상품 목록이 필요합니다.");

        return CheckoutDto.builder()
                .receiverDetails(receiverDetails)
                .customerCart(cartList)
                .paymentAmount(new PaymentAmount().toCheckoutDto(cartList))
                .build();
    }
}
