package com.brokurly.controller.order;

import com.brokurly.dto.order.CheckoutDto;
import com.brokurly.dto.order.ReceiverDetailsRequestDto;
import com.brokurly.dto.order.ReceiverDetailsResponseDto;
import com.brokurly.service.order.OrderService;
import com.brokurly.service.order.ReceiverDetailsService;
import com.brokurly.utils.StringFormatUtils;
import lombok.Getter;
import lombok.Setter;
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
    @Getter
    @Setter
    public static class TestCustomer {
        private String id;
        private String name;
        private String telNo;
        private String email;

        public TestCustomer(String id, String name, String telNo, String email) {
            this.id = id;
            this.name = name;
            this.telNo = telNo;
            this.email = email;
        }
    }

    @GetMapping("/checkout")
    public String showCheckout(Model model, HttpSession session) {
        TestCustomer customer = new TestCustomer("hong", "홍길동", "01022223333", "asd@naver.com");
        CheckoutDto checkout = null;
        try {
            checkout = orderService.getCheckoutInfo(testShipLocaId, customer.getId());
        } catch (IllegalStateException e) {
            log.error("상품 목록이 존재하지 않음", e);
        }

        if (checkout != null && checkout.getReceiverDetails() != null)
            session.setAttribute("receiverDetails", checkout.getReceiverDetails());

        customer.setTelNo(StringFormatUtils.formatPhoneNumber(customer.getTelNo()));

        session.setAttribute("customer", customer);

        model.addAttribute("customer", customer);
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
        TestCustomer customer = (TestCustomer) session.getAttribute("customer");

        model.addAttribute("receiverDetails", receiverDetails);
        model.addAttribute("customer", customer);

        return "order/receiver-details";
    }

    @PostMapping("/receiver-details")
    @ResponseBody
    public ResponseEntity<ReceiverDetailsResponseDto> saveReceiverDetails(
            @ModelAttribute ReceiverDetailsRequestDto requestSaveDto,
            BindingResult bindingResult, HttpSession session) {

        if (bindingResult.hasErrors())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        TestCustomer customer = (TestCustomer) session.getAttribute("customer");

        requestSaveDto.setShipLocaId(testShipLocaId);
        requestSaveDto.setCustId(customer.getId());

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
