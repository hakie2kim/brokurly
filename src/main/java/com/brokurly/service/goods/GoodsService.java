package com.brokurly.service.goods;

import com.brokurly.dto.goods.GoodsAnnouncementDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsForCartDto;
import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.GoodsAnnouncement;
import com.brokurly.repository.goods.GoodsDao;
import com.brokurly.repository.products.ProductsCreateDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsDao goodsDao;
    private ProductsCreateDao productsCreateDao;

    @Autowired
    public void ProductsCreateService(ProductsCreateDao productsCreateDao) {
        this.productsCreateDao = productsCreateDao;
    }

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

    public GoodsAnnouncementDto searchGoodsAnnouncement(String itemId){
        GoodsAnnouncement goodsAnnouncement = productsCreateDao.findByItemId(itemId);
        return goodsAnnouncement.makeFullDto();
    }

}
