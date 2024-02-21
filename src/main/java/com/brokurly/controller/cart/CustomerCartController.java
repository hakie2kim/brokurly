package com.brokurly.controller.cart;

import com.brokurly.entity.cart.CustomerCart;
import com.brokurly.entity.member.Member;
import com.brokurly.service.cart.CustomerCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CustomerCartController {

    private final CustomerCartService customerCartService;

    @PostMapping("/cart/add")
    @ResponseBody
    public String addCartPOST(CustomerCart customerCart, HttpServletRequest request) {
//        // 로그인 체크
        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute("member");
        System.out.println(member);
//        Member member = (Member)session.getAttribute("member");
//        if(member == null) {
//            return "5";
//        }

        // 카트 등록
        int result = customerCartService.insert(customerCart);
        return result + "";

    }


}
