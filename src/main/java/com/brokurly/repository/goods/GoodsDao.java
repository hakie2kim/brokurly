package com.brokurly.repository.goods;


import com.brokurly.entity.goods.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {

  // CREATE
  int insert(Goods goods); //장바구니에 담기
  // READ
  Goods selectByItemId(String itemId);  //optional 값이 없는 null을 optional로 감싸서 전달
  // UPDATE
  int update(Goods goods);
  // DELTE
  int deleteByItemId(String itemId);

  List<Goods> selectGoodsListbyCateCode(String cateCode);
}
