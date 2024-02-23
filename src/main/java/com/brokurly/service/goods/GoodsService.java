package com.brokurly.service.goods;

import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsForCartDto;
import com.brokurly.entity.goods.Goods;
import com.brokurly.repository.goods.GoodsDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsDao goodsDao;

    //상품 조회
    public GoodsDto searchGoods(String itemId) {    //상품정보 불러오기
        Goods goods = goodsDao.selectByItemId(itemId);
        goods.initSaleTotal();  //할인가격 계산 값
        return goods.makeFullDto();
    }

    public GoodsForCartDto searchGoodsForCart(String itemId) {
        Goods goods = goodsDao.selectByItemId(itemId);
        return goods.toGoodsForCartDto();
    }

}
