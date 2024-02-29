package com.brokurly.repository.goods;


import com.brokurly.entity.cart.Cart;
import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.GoodsAnnouncement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {

  // CREATE
  int insert(Goods goods); //상품 추가
  int addCart(Cart cart); //장바구니 상품 추가
  // READ
  Goods selectByItemId(String itemId);  //optional 값이 없는 null을 optional로 감싸서 전달
  // UPDATE
  int update(Goods goods);
  // DELTE
  int deleteByItemId(String itemId);

  List<Goods> selectGoodsListbyCateCode(String cateCode);


}
