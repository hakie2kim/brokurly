package com.brokurly.controller.cart;

import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.service.cart.CustomerCartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CustomerCartController {

    private final CustomerCartService customerCartService;

    /* 장바구니 추가 */
    @PostMapping("/add")
    @ResponseBody
    public String addCartPOST(@ModelAttribute CustomerCartDto customerCartDto, HttpSession session) {
        // 로그인 체크
        String member = (String) session.getAttribute("member");
//        System.out.println(member);
        log.info(" member = {}",member);
        log.info("cusCart={}",customerCartDto);

        if (member == null) {
            return "5";
        }

        // 카트 등록
//        return String.valueOf(customerCartService.addCart(customerCart));
        int result = customerCartService.addCart(customerCartDto);
        return result + "";
    }

    /* 장바구니 페이지 이동 */
    @GetMapping("/{custId}")
    public String cartPageGET(@PathVariable("custId") String custId, Model model) {
        List<CustomerCartDto> cart = customerCartService.getCartList(custId);
//        ArrayList<CustomerCartDto> collect = cart.stream().map(carte -> carte.makeFullDto()).collect(Collectors.toCollection(ArrayList::new));
        model.addAttribute("cart", cart);

        return "cart/cart";
    }


}
