package com.brokurly.controller;

import com.brokurly.domain.Member;
import com.brokurly.dto.ReceiverDetailsDto;
import com.brokurly.service.ReceiverDetailsService;
import com.brokurly.utils.StringFormatUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final ReceiverDetailsService receiverDetailsService;
    Member member = new Member();

    @GetMapping("/checkout")
    public String showCheckout(Model model, HttpSession session) {
//        String shipLocaId = (String) session.getAttribute("shipLocaId");
        // 임시 데이터 삽입
        ReceiverDetailsDto receiverDetails = receiverDetailsService.findReceiverDetails("112");
        if (receiverDetails != null)
            session.setAttribute("receiverDetails", receiverDetails);

        member.setName(receiverDetails.getRcvName());
        member.setTelNo(StringFormatUtils.formatPhoneNumber(receiverDetails.getTelNo()));
        member.setEmail("abc@naver.com");

//        model.addAttribute("member", session.getAttribute("member"));

        model.addAttribute("member", member);
        model.addAttribute("receiverDetails", receiverDetails);
        return "order/checkout";
    }

    @GetMapping("/receiver-details")
    public String showReceiverDetails(Model model, HttpSession session) {
        ReceiverDetailsDto receiverDetails = (ReceiverDetailsDto) session.getAttribute("receiverDetails");

//        model.addAttribute("member", session.getAttribute("member"));
        model.addAttribute("member", member);
        model.addAttribute("receiverDetails", receiverDetails);
        return "order/receiver-details";
    }
}