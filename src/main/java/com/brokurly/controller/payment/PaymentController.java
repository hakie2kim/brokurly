package com.brokurly.controller.payment;

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

@Slf4j
@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final KakaoPayService kakaoPayService;

    @PostMapping("/kakaopay")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> kakaoPayReady(@RequestBody PaymentAmountCheckoutDto paymentAmount, HttpSession session) {
        KakaoPayReadyResponseDto response = kakaoPayService.ready(paymentAmount).block();

        if (response == null)
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);

        session.setAttribute("tid", response.getTid());
        return new ResponseEntity<>(response.getNext_redirect_pc_url(), HttpStatus.OK);
    }

    @GetMapping("/kakaopay/success")
    public String kakaoPaySuccess(@RequestParam String pg_token, HttpSession session, RedirectAttributes redirectAttributes) {
        String tid = (String) session.getAttribute("tid");
        KakaoPayApproveResponseDto response = kakaoPayService.approve(pg_token, tid).block();

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
}
