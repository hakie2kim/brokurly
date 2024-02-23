package com.brokurly.controller.order;

import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.ReceiverDetailsRequestChangeDto;
import com.brokurly.dto.order.ReceiverDetailsResponseDto;
import com.brokurly.entity.member.Member;
import com.brokurly.service.member.MemberService;
import com.brokurly.service.order.OrderService;
import com.brokurly.service.order.ReceiverDetailsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ReceiverDetailsService receiverDetailsService;

    @GetMapping("/checkout")
    public String showCheckout(Model model, HttpSession session) {
        CheckoutDto checkout = null;
        try {
            checkout = orderService.getCheckoutInfo("124", "hong");
        } catch (NullPointerException e) {
            log.error("NoReceiverDetailsException", e);
        }

        if (checkout != null)
            session.setAttribute("checkout", checkout);

        model.addAttribute("checkout", checkout);
        model.addAttribute("member", new TestMember(checkout.getRcvName(), checkout.getTelNo(), "asd@naver.com"));
      
        return "order/checkout";
    }

    @Getter
    public static class TestMember {
        private String name;
        private String telNo;
        private String email;

        public TestMember(String name, String telNo, String email) {
            this.name = name;
            this.telNo = telNo;
            this.email = email;
        }
    }

    @GetMapping("/receiver-details")
    public String showReceiverDetails(Model model, HttpSession session) {
        CheckoutDto checkout = (CheckoutDto) session.getAttribute("checkout");

        model.addAttribute("checkout", checkout);

        return "order/receiver-details";
    }

    @PostMapping("/receiver-details")
    @ResponseBody
    public ResponseEntity<CheckoutDto> addReceiverDetails() {
//        orderService.
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/receiver-details")
    @ResponseBody
    public ResponseEntity<ReceiverDetailsResponseDto> modifyReceiverDetails(
            @ModelAttribute ReceiverDetailsRequestChangeDto requestChangeDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ReceiverDetailsResponseDto changedReceiverDetails = receiverDetailsService.modifyReceiverDetails("124", requestChangeDto);
        return new ResponseEntity<>(changedReceiverDetails, HttpStatus.OK);
    }
}
