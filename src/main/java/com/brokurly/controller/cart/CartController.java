package com.brokurly.controller.cart;

import com.brokurly.service.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
  private final CartService cartService;  //서비스 선언
//  @Autowired
//  public CartController(CartService cartService){
//    this.cartService = cartService;
//  }

  @GetMapping
  public String cart(@RequestParam String custId, @PathVariable String itemId, Model model){

    return "cart/cart";
  }

  //컨트롤러와 서비스 연결

//  @PostMapping("goods/goodsDetail")
//  public String addToCart(CartDto cartDto){
//
//  }


}
