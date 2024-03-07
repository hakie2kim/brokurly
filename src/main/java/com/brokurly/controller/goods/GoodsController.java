package com.brokurly.controller.goods;



import com.brokurly.dto.goods.*;
import com.brokurly.dto.mypage.WishListDto;
import com.brokurly.service.goods.GoodsService;
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
    List<GoodsInquiryLogDto> inquiry = goodsService.searchGoodsInquiryLog(itemId);  //상품 문의사항
    int wishList = goodsService.searchWish(itemId, "hong"); //상품 찜
    List<GoodsReviewBoardDto> review = goodsService.searchReview(itemId);

    model.addAttribute("goods", goods);
    model.addAttribute("announcement", announcement);
//    model.addAttribute("goodsImage", goodsImage);
    model.addAttribute("inquiry", inquiry);
    model.addAttribute("wishList",wishList);
    model.addAttribute("review",review);
    return "goods/goods";
  }
  @PostMapping("/addWish")
  @ResponseBody
  public ResponseEntity<String> addWishPost(WishListDto wishListDto){
    int result = goodsService.addWish(wishListDto); //String 이기에 int값 먼저 넣어줌
    return new ResponseEntity<>(result + "", HttpStatus.OK);
  }
  @PostMapping("/deleteWish")
  @ResponseBody
  public ResponseEntity<String> deleteWishPost(WishListDto wishListDto){
    int result = goodsService.deleteWish(wishListDto); //String 이기에 int값 먼저 넣어줌
    return new ResponseEntity<>(result + "", HttpStatus.OK);
  }

//  @PostMapping("/dateSort")
//  @ResponseBody
//  public void sortReview(String itemId, Model model) {
//    List<GoodsReviewBoardDto> review = goodsService.sortReview(itemId);
//    model.addAttribute("review", review);
////    return "goods/goods";
//  }


}