package com.brokurly.repository;

import com.brokurly.domain.GoodsImage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsImageDao {
    void insert(GoodsImage goodsImage);

    GoodsImage selectByItemId(String itemId);

    void deleteByImg(String string);

    String getThumbnailByItemId(String itemId);
}
