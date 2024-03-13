package com.brokurly.service.payment;

import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.payment.KakaoPayApproveRequestDto;
import com.brokurly.dto.payment.KakaoPayApproveResponseDto;
import com.brokurly.dto.payment.KakaoPayReadyRequestDto;
import com.brokurly.dto.payment.KakaoPayReadyResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@PropertySource("classpath:application.properties")
public class KakaoPayService {
    private final WebClient webClient;
    @Value("${kakaopay.clientId}")
    private String clientId;
    @Value("${kakaopay.secretKey}")
    private String secretKey;

    public KakaoPayService(ClientHttpConnector clientHttpConnector) {
        this.webClient = WebClient.builder()
                .baseUrl("https://open-api.kakaopay.com")
                .clientConnector(clientHttpConnector)
                .build();
    }

    public Mono<KakaoPayReadyResponseDto> ready(CheckoutDto checkoutDto, String orderId, String custId) {
        KakaoPayReadyRequestDto requestDto = KakaoPayReadyRequestDto.builder()
                .cid(clientId)
                .partner_order_id(orderId)
                .partner_user_id(custId)
                .item_name(checkoutDto.getItemName())
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
                    httpHeaders.set("Authorization", "SECRET_KEY " + secretKey);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                })
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .onStatus(HttpStatus::isError, clientResponse -> {
                    throw new ResponseStatusException(clientResponse.statusCode());
                })
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
                .cid(clientId)
                .tid(paramMap.get("tid"))
                .partner_order_id(paramMap.get("orderId"))
                .partner_user_id(paramMap.get("userId"))
                .pg_token(pg_token)
                .build();

        return webClient.post()
                .uri("/online/v1/payment/approve")
                .headers(httpHeaders -> {
                    httpHeaders.set("Authorization", "SECRET_KEY " + secretKey);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                })
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(KakaoPayApproveResponseDto.class);
    }
}
