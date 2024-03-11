package com.brokurly.controller.order;

import com.brokurly.dto.member.MemberAndLoginDto;
import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.ReceiverDetailsRequestDto;
import com.brokurly.dto.order.ReceiverDetailsResponseDto;
import com.brokurly.service.order.OrderService;
import com.brokurly.service.order.ReceiverDetailsService;
import com.brokurly.utils.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final String testShipLocaId = "111";

    @GetMapping("/checkout")
    public String showCheckout(Model model, HttpSession session) {
        MemberAndLoginDto loginMember = (MemberAndLoginDto) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (loginMember == null)
            loginMember = new MemberAndLoginDto("hong", "1234", "홍길동");

        CheckoutDto checkout = null;
        try {
            checkout = orderService.getCheckoutInfo(testShipLocaId, loginMember.getCustId());
        } catch (IllegalStateException e) {
            log.error("상품 목록이 존재하지 않음", e);
        }

//        log.info("checkout = {}", checkout);

        if (checkout != null && checkout.getReceiverDetails() != null)
            session.setAttribute("receiverDetails", checkout.getReceiverDetails());

//        customer.setTelNo(StringFormatUtils.formatPhoneNumber(customer.getTelNo()));

        model.addAttribute("loginMember", loginMember);
        model.addAttribute("checkout", checkout);

        return "order/checkout";
    }

    @GetMapping("/checkout/success")
    public String paymentSuccess(@ModelAttribute String amonut,
                                 @ModelAttribute String orderId,
                                 @ModelAttribute String userId) {
        return "order/success";
    }

    @GetMapping("/receiver-details")
    public String showReceiverDetails(Model model, HttpSession session) {
        ReceiverDetailsResponseDto receiverDetails = (ReceiverDetailsResponseDto) session.getAttribute("receiverDetails");
        model.addAttribute("receiverDetails", receiverDetails);
        return "order/receiver-details";
    }

    @PostMapping("/receiver-details")
    @ResponseBody
    public ResponseEntity<ReceiverDetailsResponseDto> saveReceiverDetails(
            @ModelAttribute ReceiverDetailsRequestDto requestSaveDto,
            BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        MemberAndLoginDto loginMember = (MemberAndLoginDto) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (loginMember == null)
            loginMember = new MemberAndLoginDto("hong", "1234", "홍길동");

        requestSaveDto.setShipLocaId(testShipLocaId);
        requestSaveDto.setCustId(loginMember.getCustId());

        ReceiverDetailsResponseDto savedReceiverDetails = receiverDetailsService.saveReceiverDetails(requestSaveDto);
        return new ResponseEntity<>(savedReceiverDetails, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "order/test";
    }

    @PatchMapping("/receiver-details")
    @ResponseBody
    public ResponseEntity<ReceiverDetailsResponseDto> modifyReceiverDetails(
            @ModelAttribute ReceiverDetailsRequestDto requestChangeDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        ReceiverDetailsResponseDto changedReceiverDetails = receiverDetailsService.modifyReceiverDetails(testShipLocaId, requestChangeDto);
        return new ResponseEntity<>(changedReceiverDetails, HttpStatus.OK);
    }
}
