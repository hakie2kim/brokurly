package com.brokurly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/checkout")
    public String showCheckout(Model model) {

        return "order/checkout";
    }

    @GetMapping("/receiver-details")
    public String showReceiverDetails() {
        return "order/receiver-details";
    }
}
