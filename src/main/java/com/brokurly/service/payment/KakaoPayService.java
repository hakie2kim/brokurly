package com.brokurly.service.payment;

import com.brokurly.dto.payment.*;
import com.brokurly.entity.payment.PaymentAmount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

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

    public Mono<KakaoPayReadyResponseDto> ready(PaymentAmountCheckoutDto paymentAmount) {
        KakaoPayReadyRequestDto requestDto = KakaoPayReadyRequestDto.builder()
                .cid(CLIENT_ID)
                .partner_order_id("1234")
                .partner_user_id("hong")
                .item_name("소불고기")
                .quantity(1)
                .total_amount(paymentAmount.getOrderAmt())
                .tax_free_amount(0)
                .approval_url("http://localhost:8080/payment/kakaopay/success")
                .cancel_url("http://localhost:8080")
                .fail_url("http://localhost:8080")
                .build();

        return webClient.post()
                .uri("/online/v1/payment/ready")
                .headers(httpHeaders -> {
                    httpHeaders.set("Authorization", "SECRET_KEY " + SECRET_KEY);
                    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                })
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(KakaoPayReadyResponseDto.class);
    }

    public Mono<KakaoPayApproveResponseDto> approve(String pg_token, String tid) {
        KakaoPayApproveRequestDto requestDto = KakaoPayApproveRequestDto.builder()
                .cid(CLIENT_ID)
                .tid(tid)
                .partner_order_id("1234")
                .partner_user_id("hong")
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
