package com.brokurly.repository;

import com.brokurly.dto.GoodsDto;
import com.brokurly.dto.ItemAnnouncementDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductscreateDao {

    void insert(GoodsDto goodsDto);

    void insertAnno(ItemAnnouncementDto itemAnnouncementDto);
}
