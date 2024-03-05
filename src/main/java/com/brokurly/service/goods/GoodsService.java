package com.brokurly.service.goods;



import com.brokurly.dto.goods.GoodsAnnouncementDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsForCartDto;
import com.brokurly.dto.goods.GoodsInquiryLogDto;
import com.brokurly.entity.goods.Goods;
import com.brokurly.entity.goods.GoodsAnnouncement;
import com.brokurly.entity.goods.GoodsInquiryLog;
import com.brokurly.repository.goods.GoodsDao;
import com.brokurly.repository.goods.GoodsInquiryLogDao;
import com.brokurly.repository.products.ProductsCreateDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
//@RequiredArgsConstructor
public class GoodsService {

    private final GoodsDao goodsDao;
    private ProductsCreateDao productsCreateDao;
//    private GoodsImageDao goodsImageDao;
    private GoodsInquiryLogDao goodsInquiryLogDao;

    @Autowired
    public GoodsService(GoodsDao goodsDao ){
        this.goodsDao = goodsDao;

    }

    @Autowired
    public void ProductsCreateService(ProductsCreateDao productsCreateDao) {
        this.productsCreateDao = productsCreateDao;
    }

//    @Autowired
//    public void GoodsImageService(GoodsImageDao goodsImageDao){
//        this.goodsImageDao = goodsImageDao;
//    }

    @Autowired
    public void GoodsInquiryLogService(GoodsInquiryLogDao goodsInquiryLogDao){
        this.goodsInquiryLogDao = goodsInquiryLogDao;
    }

    //상품 조회
    public GoodsDto searchGoods(String itemId) {    //상품정보 불러오기
        Goods goods = goodsDao.selectByItemId(itemId);
        goods.initSaleTotal();  //할인가격 계산 값
        return goods.makeFullDto();
    }

    public GoodsForCartDto searchGoodsForCart(String itemId) {
        Goods goods = goodsDao.selectByItemId(itemId);
        return goods.toGoodsForCartDto();
    }

    public GoodsAnnouncementDto searchGoodsAnnouncement(String itemId) {    //상품고시정보 불러오기
        GoodsAnnouncement goodsAnnouncement = productsCreateDao.findByItemId(itemId);
        return goodsAnnouncement.makeFullDto();
    }

//    public GoodsImageDto searchGoodsImage(String itemId){     //상품 이미지 불러오기
//        GoodsImage goodsImage = goodsImageDao.selectByItemId(itemId);
//        return goodsImage.makeFullDto();
//    }

    public List<GoodsInquiryLogDto> searchGoodsInquiryLog(String itemId){
        List<GoodsInquiryLog> goodsInquiryLogList = goodsInquiryLogDao.selectByItemId(itemId);
        List<GoodsInquiryLogDto> goodsInquiryLogDto = new ArrayList<>();

        for(GoodsInquiryLog goodsInquiryLog : goodsInquiryLogList){
            goodsInquiryLogDto.add(goodsInquiryLog.makeFullDto());
        }

        return goodsInquiryLogDto;
    }

}
