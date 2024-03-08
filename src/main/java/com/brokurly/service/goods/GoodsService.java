package com.brokurly.service.goods;


import com.brokurly.dto.cart.CartDto;
import com.brokurly.dto.goods.GoodsAnnouncementDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsForCartDto;
import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.GoodsAnnouncement;
import com.brokurly.repository.goods.GoodsDao;
import com.brokurly.repository.products.ProductsCreateDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
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
        return goods.makeFullDto();
    }

    public GoodsForCartDto searchGoodsForCart(String itemId) {
        Goods goods = goodsDao.selectByItemId(itemId);
        return goods.toGoodsForCartDto();
    }


    public GoodsAnnouncementDto searchGoodsAnnouncement(String itemId) {
        GoodsAnnouncement goodsAnnouncement = productsCreateDao.findByItemId(itemId);
        return goodsAnnouncement.makeFullDto();
    }
    //상품 카트에 담기
    @Transactional
    public void addCart(CartDto cartDto) {
        Goods goods = new Goods();
//    cart.changeStatus(cartDto);
        goodsDao.insert(goods);

    }

}
