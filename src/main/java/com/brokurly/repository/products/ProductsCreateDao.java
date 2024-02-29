package com.brokurly.repository.products;

import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.GoodsAnnouncement;
import com.brokurly.entity.goods.GoodsImage;
import com.brokurly.entity.search.SearchKeyword;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductsCreateDao {

    //goods 상품
    int insert(Goods goods);
    Goods selectByItemId(String itemId);
    int updateItem(Goods goods);

    List<Goods> selectByBsnsNo(String bsns_no);



    //goodsAnnouncement 상품고시정보
    int insertAnnouncement(GoodsAnnouncement goodsAnnouncementAnnouncement);
    String selectAnnouncementByItemId(String itemId);


    //searchKeyword 키워드
    int insertSearchKeyword(SearchKeyword searchKeyword);
    int updateSearchKeyword(SearchKeyword searchKeyword);
    SearchKeyword selectByKeyword(String keyword);

    int selectKeywordExist(String keyword);

    int updateItemIdList(SearchKeyword searchKeyword);

    List<String> selectItemIdListByKeyword(String keyword);


    //Goodsimage 상품 이미지
    int insertGoodsImage(GoodsImage goodsImage);

    GoodsAnnouncement findByItemId(String itemId);  //상품고시정보 조회
}
