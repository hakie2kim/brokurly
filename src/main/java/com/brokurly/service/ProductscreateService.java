package com.brokurly.service;

import com.brokurly.domain.Goods;
import com.brokurly.dto.GoodsDto;
import com.brokurly.repository.ProductscreateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductscreateService {

    ProductscreateDao productscreateDao;

    //생성자 추가해서 주입받기
    @Autowired
    public ProductscreateService(ProductscreateDao productscreateDao){
        this.productscreateDao = productscreateDao;
    }


    //상품명 insert test
    public void write(GoodsDto goodsDto){
        productscreateDao.insert(goodsDto);
    }


}
