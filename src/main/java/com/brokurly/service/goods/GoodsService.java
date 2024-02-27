package com.brokurly.service.goods;


import com.brokurly.dto.cart.CartDto;
import com.brokurly.dto.goods.GoodsByBsnsNoDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsForCartDto;
import com.brokurly.entity.goods.Goods;
import com.brokurly.repository.goods.GoodsDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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
