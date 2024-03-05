package com.brokurly.controller.goods;


import com.brokurly.dto.goods.GoodsAnnouncementDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsImageDto;
import com.brokurly.dto.goods.GoodsInquiryLogDto;
import com.brokurly.entity.goods.GoodsImage;
import com.brokurly.service.goods.GoodsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        GoodsDto goods = goodsService.searchGoods(itemId);  // 상품정보
        GoodsAnnouncementDto announcement = goodsService.searchGoodsAnnouncement(itemId); //상품고시정보
//    GoodsImageDto goodsImage = goodsService.searchGoodsImage(itemId); //상품 이미지
        List<GoodsInquiryLogDto> inquiry = goodsService.searchGoodsInquiryLog(itemId);
        model.addAttribute("goods", goods);
        model.addAttribute("announcement", announcement);
//    model.addAttribute("goodsImage", goodsImage);
        model.addAttribute("inquiry", inquiry);

        return "goods/goods";
    }

}