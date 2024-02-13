package com.brokurly.controller;

import com.brokurly.dto.ReceiverDetailsDto;
import com.brokurly.service.ReceiverDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final ReceiverDetailsService receiverDetailsService;
    private ReceiverDetailsDto receiverDetailsDto;

    @GetMapping("/checkout")
    public String showCheckout(Model model) {
        // 추후에 배송지 아이디 가져오는 로직 필요함
        ReceiverDetailsDto receiverDetails = receiverDetailsService.findReceiverDetails("123");
        model.addAttribute("receiverDetails", receiverDetails);
        receiverDetailsDto = receiverDetails;
        return "order/checkout";
    }

    @GetMapping("/receiver-details")
    public String showReceiverDetails(Model model) {
        if (receiverDetailsDto != null)
            model.addAttribute("receiverDetails", receiverDetailsDto);
        return "order/receiver-details";
    }
}
