package com.brokurly.service.payment;

import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.payment.KakaoPayApproveRequestDto;
import com.brokurly.dto.payment.KakaoPayApproveResponseDto;
import com.brokurly.dto.payment.KakaoPayReadyRequestDto;
import com.brokurly.dto.payment.KakaoPayReadyResponseDto;
import com.brokurly.utils.OrderNumberGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class KakaoPayService {
    private final WebClient webClient;
    private static final String CLIENT_ID = "TC0ONETIME";
    private static final String SECRET_KEY = "DEV7A4E20E00FB8E6B9769563EDDD14423A69B4C";

    public KakaoPayService(ClientHttpConnector clientHttpConnector) {
        this.webClient = WebClient.builder()
                .baseUrl("https://open-api.kakaopay.com")
                .clientConnector(clientHttpConnector)
                .build();
    }

    public Mono<KakaoPayReadyResponseDto> ready(CheckoutDto checkoutDto) {
        KakaoPayReadyRequestDto requestDto = KakaoPayReadyRequestDto.builder()
                .cid(CLIENT_ID)
                .partner_order_id(OrderNumberGenerator.generateOrderNumber())
                .partner_user_id(checkoutDto.getRcvName())
                .item_name(getItemName(checkoutDto.getCustomerCart()))
                .quantity(getQuantity(checkoutDto.getCustomerCart()))
                .total_amount(checkoutDto.getPaymentAmount().getOrderAmt())
                .tax_free_amount(0)
                .approval_url("http://localhost:8080/payment/kakaopay/success")
                .cancel_url("http://localhost:8080/payment/cancel")
                .fail_url("http://localhost:8080/payment/fail")
                .build();

        return webClient.post()
                .uri("/online/v1/payment/ready")
                .headers(httpHeaders -> {
                    httpHeaders.set("Authorization", "SECRET_KEY " + SECRET_KEY);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                })
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(KakaoPayReadyResponseDto.class)
                .map(response -> {
                    response.setPartner_order_id(requestDto.getPartner_order_id());
                    response.setPartner_user_id(requestDto.getPartner_user_id());
                    return response;
                });
    }

    private String getItemName(List<CustomerCartDto> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException();

        CustomerCartDto customerCartDto = list.get(0);
        // 문자열 포맷: XXX 외 N개
        return String.format("%s 외 %d개", customerCartDto.getName(), list.size());
    }

    private Integer getQuantity(List<CustomerCartDto> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException();

        return list.stream()
                .mapToInt(CustomerCartDto::getItemCnt)
                .sum();
    }

    public Mono<KakaoPayApproveResponseDto> approve(String pg_token, Map<String, String> paramMap) {
        KakaoPayApproveRequestDto requestDto = KakaoPayApproveRequestDto.builder()
                .cid(CLIENT_ID)
                .tid(paramMap.get("tid"))
                .partner_order_id(paramMap.get("orderId"))
                .partner_user_id(paramMap.get("userId"))
                .pg_token(pg_token)
                .build();

        return webClient.post()
                .uri("/online/v1/payment/approve")
                .headers(httpHeaders -> {
                    httpHeaders.set("Authorization", "SECRET_KEY " + SECRET_KEY);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                })
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(KakaoPayApproveResponseDto.class);
    }
}
