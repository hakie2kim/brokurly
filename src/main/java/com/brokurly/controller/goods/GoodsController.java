package com.brokurly.controller.goods;


import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.service.goods.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {
  private final GoodsService goodsService;
  private GoodsDto goodsDto;

  //상품 상세페이지로 값 전달
  @GetMapping
  public String goods(Model model){
    GoodsDto goods = goodsService.searchGoods("1234");  //임시 상품번호
    model.addAttribute("goods",goods);
    goodsDto = goods;
    return "goods/goods";
  }




//  @GetMapping("/goodSDetail")
//  public String getGoodsDetailPage(@RequestParam("item_id")int itemtId, Model model) {
//    //itemId를 사용하여 상품 정보 조회
//
//
//    Goods goods = service.getProductById(itemId);
//
//    // 조회된 상품 정보를 모델에 추가하여 뷰로 전달
//    model.addAttribute("goods", goods);
//
//    return "goods/goodsDetail"; // productDetail.jsp와 같은 뷰 페이지를 반환합니다.
//  }

}
