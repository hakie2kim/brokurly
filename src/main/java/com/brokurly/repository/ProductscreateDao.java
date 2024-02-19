package com.brokurly.repository;

import com.brokurly.domain.Goods;
import com.brokurly.domain.ItemAnnouncement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductscreateDao {

    void insert(Goods goods);

    void insertAnnouncement(ItemAnnouncement itemAnnouncement);
}