package com.brokurly.repository;

import com.brokurly.domain.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartDao {  //2. 반환값/mapper에서 사용할 쿼리 아이디/넣을 값
  Cart selectByItemId (String itemId);
  Cart selectByCustId(String custId);
  Cart selectByitemCnt(int itemCnt);

//  void delete(String itemId);

//  void insert(Cart cart);
//  void update(Cart cart);

//  int select(Cart cart);

}
