package com.brokurly.service.products;

import com.brokurly.dto.goods.GoodsAnnouncementDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.search.SearchKeywordDto;
import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.GoodsAnnouncement;
import com.brokurly.entity.search.SearchKeyword;
import com.brokurly.repository.products.ProductsCreateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductsCreateService {

    private final ProductsCreateDao productsCreateDao;

    //생성자 추가해서 주입받기
    @Autowired
    public ProductsCreateService(ProductsCreateDao productsCreateDao) {
        this.productsCreateDao = productsCreateDao;
    }

    // 상품 table에 insert
    @Transactional
    public int write(GoodsDto goodsDto) {
        Goods goods = new Goods();        //Goods 도메인 만들기
        goods.changeStatus(goodsDto);     //goodsDto에 있는 값으로 goods의 상태를 변경한다.
        return productsCreateDao.insert(goods);  //goods insert
    }

    // 상품정보고시 table에 insert
    @Transactional
    public int writeAnnouncement(GoodsAnnouncementDto goodsAnnouncementDto){
        GoodsAnnouncement goodsAnnouncement = new GoodsAnnouncement();
        goodsAnnouncement.changeStatus(goodsAnnouncementDto);
       return productsCreateDao.insertAnnouncement(goodsAnnouncement);
    }

    // SearchKeyword table에 insert
    @Transactional
    public int writeKeyword(SearchKeywordDto searchKeywordDto){
        SearchKeyword searchKeyword = new SearchKeyword();
        searchKeyword.changeStatus(searchKeywordDto);
       return productsCreateDao.insertSearchKeyword(searchKeyword);
    }

}
