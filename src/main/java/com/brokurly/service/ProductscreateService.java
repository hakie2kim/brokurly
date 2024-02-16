package com.brokurly.service;

import com.brokurly.domain.Goods;
import com.brokurly.domain.ItemAnnouncement;
import com.brokurly.dto.GoodsDto;
import com.brokurly.dto.ItemAnnouncementDto;
import com.brokurly.repository.ProductscreateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductscreateService {

    private final ProductscreateDao productscreateDao;

    //생성자 추가해서 주입받기
    @Autowired
    public ProductscreateService(ProductscreateDao productscreateDao) {
        this.productscreateDao = productscreateDao;
    }

    // 상품 table에 insert
    @Transactional
    public void write(GoodsDto goodsDto) {
        Goods goods = new Goods();
        goods.changeStatus(goodsDto);
        productscreateDao.insert(goods);
    }

    // 상품정보고시 table에 insert
    @Transactional
    public void writeAnnouncement(ItemAnnouncementDto itemAnnouncementDto){
        ItemAnnouncement itemAnnouncement = new ItemAnnouncement();
        itemAnnouncement.changeStatus(itemAnnouncementDto);
        productscreateDao.insertAnnouncement(itemAnnouncement);
    }

}
