package com.brokurly.service.products;

import com.brokurly.dto.goods.GoodsAnnouncementDto;
import com.brokurly.dto.goods.GoodsByBsnsNoDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsImageDto;
import com.brokurly.dto.search.SearchKeywordDto;
import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.GoodsAnnouncement;
import com.brokurly.entity.goods.GoodsImage;
import com.brokurly.entity.search.SearchKeyword;
import com.brokurly.repository.products.ProductsCreateDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    //GoodsImage insert
    @Transactional
    public int writeGoodsImage(GoodsImageDto goodsImageDto){
        GoodsImage goodsImage = new GoodsImage();
        goodsImage.changeStatus(goodsImageDto);
        return productsCreateDao.insertGoodsImage(goodsImage);
    }

    //상품 조회
    public GoodsDto searchGoods(String itemId) {
        Goods goods = productsCreateDao.selectByItemId(itemId);

        return goods.makeFullDto();
    }


    //bsnsNo로 상품 조회
    @Transactional
    public List<GoodsByBsnsNoDto> readByBsnsNo(String bsnsNo) {
        //1. Goods 도메인 리스트를 받아온다.
        List<Goods> goodsList = productsCreateDao.selectByBsnsNo("4659877658");
        log.info("goodsList={}", goodsList);

        //2. 비어있는 dto list 만들기
        List<GoodsByBsnsNoDto> dtoList = new ArrayList<>();
        //3. dto로 변환해서 list에 넣기
        for (Goods goods : goodsList) {
            dtoList.add(goods.toGoodsByBsnsNoDto("4659877658"));
        }
        log.info("dto={}", dtoList);

        return dtoList;
    }

}
