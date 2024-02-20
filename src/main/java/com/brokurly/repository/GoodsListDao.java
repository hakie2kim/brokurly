package com.brokurly.repository;

import com.brokurly.domain.GoodsList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsListDao {

    List<GoodsList> selectGoodsListbyCateCode(String cateCode);
}
