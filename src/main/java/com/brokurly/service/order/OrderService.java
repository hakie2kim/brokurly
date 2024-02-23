package com.brokurly.service.order;

import com.brokurly.dto.cart.CartDto;
import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.ReceiverDetailsResponseDto;
import com.brokurly.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CartService cartService;
    private final ReceiverDetailsService receiverDetailsService;

    @Transactional
    public CheckoutDto getCheckoutInfo(String shipLocaId, String custId) {
        ReceiverDetailsResponseDto receiverDetails = receiverDetailsService.findReceiverDetails(shipLocaId);
        List<CartDto> cartList = cartService.findItemsInCustomerCart(custId);

        if (receiverDetails == null)
            throw new NullPointerException("해당 배송지 아이디에 맞는 요청사항이 존재하지 않습니다.");

        return CheckoutDto.builder()
                .rcvName(receiverDetails.getRcvName())
                .telNo(receiverDetails.getTelNo())
                .rcvPlace(receiverDetails.getRcvPlace())
                .enterMthd(receiverDetails.getEnterMthd())
                .placeExp(receiverDetails.getPlaceExp())
                .msgTime(receiverDetails.getMsgTime())
                .customerCart(cartList)
                .build();
    }
}
