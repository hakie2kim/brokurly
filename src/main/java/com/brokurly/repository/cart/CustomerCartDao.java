package com.brokurly.repository.cart;



import com.brokurly.entity.cart.Cart;
import com.brokurly.entity.cart.CustomerCart;

import java.util.List;

public interface CustomerCartDao {

    List<CustomerCart> getCart(String custId);  //장바구니 목록
    List<CustomerCart> selectByCustId(String custId);
    CustomerCart selectByItemId(String itemId); //상품 아이디로 검색
    int deleteOneItem(CustomerCart customerCart); //장바구니 상품 하나 삭제
    int deleteAll(CustomerCart customerCart);//장바구니 전체삭제
    int update(CustomerCart customerCart); //장바구니 수정
    int insert(CustomerCart customerCart) throws Exception; //장바구니 추가??
    CustomerCart checkCart(CustomerCart customerCart);  //카트 확인
}
