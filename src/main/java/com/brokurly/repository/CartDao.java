package com.brokurly.repository;

import com.brokurly.domain.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartDao {  //2. 반환값/mapper에서 사용할 쿼리 아이디/넣을 값
  List<Cart> selectByCustId(String custId);  //장바구니 검색
  void delete(Cart cart); //장바구니 삭제
  void update(Cart cart); //장바구니 수정
  void insert(Cart cart); //장바구니 추가



}
