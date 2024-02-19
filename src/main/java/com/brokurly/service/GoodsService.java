package com.brokurly.service;

import com.brokurly.domain.Cart;
import com.brokurly.domain.Goods;
import com.brokurly.dto.CartDto;
import com.brokurly.dto.GoodsDto;
import com.brokurly.dto.GoodsForCartDto;
import com.brokurly.repository.GoodsDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class GoodsService {

  private final GoodsDao goodsDao;

  //상품 조회
  public GoodsDto searchGoods(String itemId) {
    Goods goods = goodsDao.selectByItemId(itemId);

    return goods.makeFullDto();
  }

  public GoodsForCartDto searchGoodsForCart(String itemId) {
    Goods goods = goodsDao.selectByItemId(itemId);
    return goods.toGoodsForCartDto();
  }

  //상품 카트에 담기
  @Transactional
  public void addCart(CartDto cartDto) {
    Goods goods = new Goods();
//    cart.changeStatus(cartDto);
    goodsDao.insert(goods);
  }


}