package com.brokurly.repository;

import com.brokurly.domain.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CartDao {  //2. 반환값/mapper에서 사용할 쿼리 아이디/넣을 값
  void insertCart(Cart cart);


}
