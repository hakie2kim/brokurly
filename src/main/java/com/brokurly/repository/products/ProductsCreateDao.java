package com.brokurly.repository.products;

import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.GoodsAnnouncement;
import com.brokurly.entity.search.SearchKeyword;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductsCreateDao {

    //goods 상품
    int insert(Goods goods);
    Goods selectItemByItemId(String itemId);
    int updateItem(Goods goods);


    //goodsAnnouncement 상품고시정보
    int insertAnnouncement(GoodsAnnouncement goodsAnnouncementAnnouncement);


    //searchKeyword 키워드
    int insertSearchKeyword(SearchKeyword searchKeyword);
    int updateSearchKeyword(SearchKeyword searchKeyword);
    SearchKeyword selectSearchKeywordByKeyword(String keyword);


}
