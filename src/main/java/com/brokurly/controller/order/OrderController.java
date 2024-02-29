package com.brokurly.controller.order;

import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.ReceiverDetailsRequestDto;
import com.brokurly.dto.order.ReceiverDetailsResponseDto;
import com.brokurly.service.order.OrderService;
import com.brokurly.service.order.ReceiverDetailsService;
import com.brokurly.utils.StringFormatUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.NoSuchElementException;

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
            checkout = orderService.getCheckoutInfo("111", "hong");
        } catch (IllegalStateException e) {
            log.error("상품 목록이 존재하지 않음", e);
        }

        if (checkout != null && checkout.getReceiverDetails() != null)
            session.setAttribute("receiverDetails", checkout.getReceiverDetails());

        TestMember member = new TestMember("홍길동", "01022223333", "asd@naver.com");
        member.setTelNo(StringFormatUtils.formatPhoneNumber(member.getTelNo()));

        session.setAttribute("member", member);

        model.addAttribute("checkout", checkout);
        model.addAttribute("member", member);

        return "order/checkout";
    }

    @GetMapping("/checkout/success")
    public String paymentSuccess(@ModelAttribute String amonut,
                                 @ModelAttribute String orderId,
                                 @ModelAttribute String userId) {
        return "order/success";
    }

    @Getter
    @Setter
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
        ReceiverDetailsResponseDto receiverDetails = (ReceiverDetailsResponseDto) session.getAttribute("receiverDetails");
        TestMember member = (TestMember) session.getAttribute("member");

        model.addAttribute("receiverDetails", receiverDetails);
        model.addAttribute("member", member);

        return "order/receiver-details";
    }

    @PostMapping("/receiver-details")
    @ResponseBody
    public ResponseEntity<ReceiverDetailsResponseDto> saveReceiverDetails(
            @ModelAttribute ReceiverDetailsRequestDto requestSaveDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        requestSaveDto.setShipLocaId("111");
        requestSaveDto.setCustId("hong");

        ReceiverDetailsResponseDto savedReceiverDetails = receiverDetailsService.saveReceiverDetails(requestSaveDto);
        return new ResponseEntity<>(savedReceiverDetails, HttpStatus.OK);
    }

    @PatchMapping("/receiver-details")
    @ResponseBody
    public ResponseEntity<ReceiverDetailsResponseDto> modifyReceiverDetails(
            @ModelAttribute ReceiverDetailsRequestDto requestChangeDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ReceiverDetailsResponseDto changedReceiverDetails = receiverDetailsService.modifyReceiverDetails("111", requestChangeDto);
        return new ResponseEntity<>(changedReceiverDetails, HttpStatus.OK);
    }
}
