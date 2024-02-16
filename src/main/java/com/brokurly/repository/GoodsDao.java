package com.brokurly.repository;


import com.brokurly.domain.Cart;
import com.brokurly.domain.Goods;
import org.apache.ibatis.annotations.Mapper;


import java.util.Optional;

@Mapper
public interface GoodsDao {

  // CREATE
  void insert(Cart cart); //장바구니에 담기
  // READ
  Goods selectByItemId(String itemId);  //optional 값이 없는 null을 optional로 감싸서 전달

  // UPDATE

  // DELTE

}
