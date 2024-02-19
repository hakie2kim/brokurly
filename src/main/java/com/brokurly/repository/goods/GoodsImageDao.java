package com.brokurly.repository.goods;

import com.brokurly.entity.goods.GoodsImage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsImageDao {
    void insert(GoodsImage goodsImage);

    GoodsImage selectByItemId(String itemId);

    void deleteByImg(String string);
}
