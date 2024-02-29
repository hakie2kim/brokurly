package com.brokurly.controller.payment;

import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.payment.KakaoPayApproveResponseDto;
import com.brokurly.dto.payment.KakaoPayReadyResponseDto;
import com.brokurly.dto.payment.PaymentAmountCheckoutDto;
import com.brokurly.service.payment.KakaoPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final KakaoPayService kakaoPayService;

    @PostMapping("/kakaopay")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> kakaoPayReady(@RequestBody CheckoutDto checkout, HttpSession session) {
        KakaoPayReadyResponseDto response = kakaoPayService.ready(checkout).block();

        if (response == null)
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);

        session.setAttribute("tid", response.getTid());
        session.setAttribute("userId", response.getPartner_user_id());
        session.setAttribute("orderId", response.getPartner_order_id());
        return new ResponseEntity<>(response.getNext_redirect_pc_url(), HttpStatus.OK);
    }

    @GetMapping("/kakaopay/success")
    public String kakaoPaySuccess(@RequestParam String pg_token, HttpSession session, RedirectAttributes redirectAttributes) {
        KakaoPayApproveResponseDto response = kakaoPayService.approve(pg_token, setParamMap(session)).block();

        log.info("success in");
        log.info("response = {}", response);

        if (response == null) {
            log.info("response 없음");
            return "/order/checkout";
        }

        log.info("Approve Response = {}", response);
        redirectAttributes.addFlashAttribute("orderId", response.getPartner_order_id());
        redirectAttributes.addFlashAttribute("userId", response.getPartner_user_id());
        redirectAttributes.addFlashAttribute("amount", response.getAmount().getTotal());
        return "redirect:/order/checkout/success";
    }

    private Map<String, String> setParamMap(HttpSession session) {
        Map<String, String> paramMap = new HashMap<>();

        String tid = (String) session.getAttribute("tid");
        String userId = (String) session.getAttribute("userId");
        String orderId = (String) session.getAttribute("orderId");

        paramMap.put("tid", tid);
        paramMap.put("userId", userId);
        paramMap.put("orderId", orderId);

        return paramMap;
    }

    @GetMapping("/cancel")
    public String cancel() {
        log.info("cancel in");
        return "payment/cancel";
    }

    @GetMapping("/fail")
    public String fail() {
        log.info("fail in");
        return "payment/fail";
    }
}
