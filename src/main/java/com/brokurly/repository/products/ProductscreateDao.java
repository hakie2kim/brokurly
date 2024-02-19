package com.brokurly.repository.products;

import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.ItemAnnouncement;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductscreateDao {

    void insert(Goods goods);

    void insertAnnouncement(ItemAnnouncement itemAnnouncement);
}
