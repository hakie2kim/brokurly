package com.brokurly.controller.cart;

import com.brokurly.dto.cart.CustomerCartDto;
import com.brokurly.dto.mypage.ShippingLocationCurrDto;
import com.brokurly.dto.mypage.ShippingLocationDto;
import com.brokurly.repository.mypage.ShippingLocationDao;
import com.brokurly.service.cart.CustomerCartService;
import com.brokurly.service.mypage.ShippingLocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final ShippingLocationService shippingLocationService;

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
        int result = customerCartService.addCart(customerCartDto);
        return result + "";
    }

    /* 장바구니 페이지 이동 */
    @GetMapping("/{custId}")
    public String cartPageGET(@PathVariable("custId") String custId, Model model) {
        List<CustomerCartDto> cart = customerCartService.getCartList(custId);
        ShippingLocationCurrDto address = shippingLocationService.getCurrShippingLocationByCustomer(custId);

        model.addAttribute("cart", cart);
        model.addAttribute("address", address);
        return "cart/cart";
    }

    //장바구니 수량 수정
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<CustomerCartDto> updateCartPOST(@ModelAttribute CustomerCartDto customerCartDto) {
//        log.info("cartDto = {}", customerCartDto);
        CustomerCartDto cartDto = customerCartService.update(customerCartDto);

        if (cartDto == null) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteCart(@ModelAttribute CustomerCartDto customerCartDto){
        CustomerCartDto cartDto = customerCartService.deleteCart(customerCartDto);
        return "redirect:/cart/{custId}";
    }

    @PostMapping("/vacate")
    @ResponseBody
    public void vacateCart(@ModelAttribute CustomerCartDto customerCartDto){
        CustomerCartDto cartDto = customerCartService.vacateCart(customerCartDto);

    }
}
