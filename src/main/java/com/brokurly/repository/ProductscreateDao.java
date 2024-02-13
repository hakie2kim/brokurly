package com.brokurly.repository;

import com.brokurly.dto.GoodsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductscreateDao {

    void insert(GoodsDto goodsDto);

}
