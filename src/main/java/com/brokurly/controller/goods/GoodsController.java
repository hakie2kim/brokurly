package com.brokurly.controller.goods;


import com.brokurly.dto.cart.CartDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.service.goods.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {

  private final GoodsService goodsService;

  // 상품 상세페이지로 값 전달
  @GetMapping("/{itemId}")
  public String goods(@PathVariable("itemId") String itemId, Model model, HttpSession session) {
    session.setAttribute("member", "hong");
    GoodsDto goods = goodsService.searchGoods(itemId);  // 임시 상품번호
    model.addAttribute("goods", goods);
    return "goods/goods";
  }

}