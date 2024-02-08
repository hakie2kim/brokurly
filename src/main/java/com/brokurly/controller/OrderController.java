package com.brokurly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/checkout")
    public String showCheckout() {
        return "order/checkout";
    }
}
