package com.brokurly.repository;

import com.brokurly.domain.Goods;
import com.brokurly.domain.GoodsAnnouncement;
import com.brokurly.domain.ReceiverDetails;
import com.brokurly.domain.SearchKeyword;
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
