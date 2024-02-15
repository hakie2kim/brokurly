package com.brokurly.repository;

import com.brokurly.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao {
  Goods selectByItemId(String itemId);

}
