package com.brokurly.service;


import com.brokurly.domain.Cart;
import com.brokurly.dto.CartDto;
import com.brokurly.dto.GoodsDto;
import com.brokurly.dto.GoodsForCartDto;
import com.brokurly.repository.CartDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

  private final CartDao cartDao;  //final을 붙여 기본생성자 자동생성(@RequiredArgsConstructor가 만들어줌)
  private final GoodsService goodsService;

//  @Transactional  //문제가 생겼을때 롤백가능하게 해줌(하나라도 실패하면 롤백)(검색같은건 생성하거나 지운게 없어 안써도됨)
//  public void addCart(GoodsDto goodsDto,){
//    Cart cart = new Cart();
//    cart.changeStatus(cartDto); //dto값을 domain에 넣기
//    cartDao.insert(cart); //domain값을 dao에
//  }

  public List<CartDto> findItemsInCustomerCart(String custId) {
    List<Cart> cartList = cartDao.selectByCustId(custId);
    List<CartDto> itemList = new ArrayList<>();
    for (Cart cart : cartList) {
      GoodsForCartDto goodsDto = goodsService.searchGoodsForCart(cart.getItemId());
      CartDto cartDto = cart.makeFullDto(goodsDto);
      itemList.add(cartDto);
    }
    return itemList;
  }

  //goodDto받아오기


}