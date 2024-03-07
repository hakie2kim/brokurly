package com.brokurly.service.order;

import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.ReceiverDetailsResponseDto;
import com.brokurly.entity.order.Order;
import com.brokurly.entity.order.OrderItemList;
import com.brokurly.entity.payment.PaymentAmount;
import com.brokurly.repository.order.OrderDao;
import com.brokurly.service.cart.CustomerCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;

    private final CustomerCartService cartService;
    private final ReceiverDetailsService receiverDetailsService;

    public CheckoutDto getCheckoutInfo(String shipLocaId, String custId) {
        List<CustomerCartDto> cartList = cartService.getCartList(custId, true);
        ReceiverDetailsResponseDto receiverDetails = receiverDetailsService.findReceiverDetails(shipLocaId);

        if (cartList == null)
            throw new IllegalStateException("주문을 위해서는 반드시 상품 목록이 필요합니다.");

        return CheckoutDto.builder()
                .receiverDetails(receiverDetails)
                .customerCart(cartList)
                .paymentAmount(new PaymentAmount().toCheckoutDto(cartList))
                .build();
    }

    @Transactional
    public void placeOrder(CheckoutDto checkoutDto, String orderId, String custId) {
        if (checkoutDto == null)
            throw new IllegalArgumentException();

        // 주문 내역 저장
        Order order = new Order();
        order.changeOrder(checkoutDto, orderId, custId);
        orderDao.insert(order);

        // 주문 상품 목록 저장
        for (CustomerCartDto customerCartDto : checkoutDto.getCustomerCart()) {
            OrderItemList itemList = new OrderItemList();
            itemList.changeOrderItemList(customerCartDto, orderId);
            orderDao.insertItemList(itemList);
        }
    }

    @Transactional
    public void cancelOrder(String orderId) {
        orderDao.deleteById(orderId);
    }
}
