package com.brokurly.service.goods;


import com.brokurly.dto.cart.CartDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsForCartDto;
import com.brokurly.entity.cart.Cart;
import com.brokurly.entity.goods.Goods;
import com.brokurly.repository.goods.GoodsDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


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

//    상품 카트에 담기
    public void addCart(CartDto cartDto) {
        Cart cart = new Cart();
        cart.changeStatus(cartDto);
        goodsDao.addCart(cart);
    }

}
