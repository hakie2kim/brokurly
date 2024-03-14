package com.brokurly.repository.goods;

import com.brokurly.entity.goods.GoodsImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsImageDao {
    int insert(GoodsImage goodsImage);

    GoodsImage selectByItemId(String itemId);
    List<GoodsImage> selectListByItemId(String itemId);

    void deleteByImg(String string);

    String getThumbnailByItemId(String itemId);
}
