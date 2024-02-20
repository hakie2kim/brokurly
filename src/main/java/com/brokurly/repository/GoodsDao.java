package com.brokurly.repository;

import com.brokurly.domain.Goods;
import com.brokurly.domain.GoodsList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {
  Goods selectByItemId(String itemId);

  List<Goods> selectGoodsListbyCateCode(String cateCode);

}
