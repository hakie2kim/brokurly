package com.brokurly.controller.payment;

import com.brokurly.dto.member.MemberAndLoginDto;
import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.payment.KakaoPayApproveResponseDto;
import com.brokurly.dto.payment.KakaoPayReadyResponseDto;
import com.brokurly.service.order.OrderService;
import com.brokurly.service.payment.KakaoPayService;
import com.brokurly.utils.IdGenerator;
import com.brokurly.utils.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final OrderService orderService;
    private final KakaoPayService kakaoPayService;

    @PostMapping("/kakaopay")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> kakaoPayReady(@RequestBody CheckoutDto checkout, HttpSession session) {
        String orderId = IdGenerator.generateOrderId();
        MemberAndLoginDto loginMember = (MemberAndLoginDto) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (loginMember == null)
            loginMember = new MemberAndLoginDto("hong", "1234", "홍길동");

        KakaoPayReadyResponseDto response;
        try {
            response = kakaoPayService.ready(checkout, orderId).block();
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        orderService.placeOrder(checkout, orderId, loginMember.getCustId());

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

        if (response == null) {
            log.info("response 없음");
            return "/order/checkout";
        }

        log.info("Approve Response = {}", response);
        // 결제 성공 시 보여줄 화면에 데이터 전달
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
    public String cancel(HttpSession session) {
        // 결제 실패 시 DB에서 해당 주문 건을 삭제
        orderService.cancelOrder((String) session.getAttribute("orderId"));
        return "payment/cancel";
    }

    @GetMapping("/fail")
    public String fail() {
        log.info("fail in");
        return "payment/fail";
    }
}
