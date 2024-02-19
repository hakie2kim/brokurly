package com.brokurly.controller;


import com.brokurly.dto.GoodsDto;
import com.brokurly.dto.GoodsAnnouncementDto;
import com.brokurly.dto.SearchKeywordDto;
import com.brokurly.service.ProductsCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/seller")
public class ProductsCreateController {

   private final ProductsCreateService productsCreateService;


    @Autowired
    public ProductsCreateController(ProductsCreateService productsCreateService){
        this.productsCreateService = productsCreateService;
    }

    @PostMapping("/productsCreate/write")
    public String writeproducts(GoodsDto goodsDto, GoodsAnnouncementDto goodsAnnouncementDto, SearchKeywordDto searchKeywordDto){
        String a = goodsDto.getName();
        log.info("a={}",a);

        log.info("goodsDto={}",goodsDto);

        log.info("itemId={}",goodsDto.getItemId());

        String b = goodsAnnouncementDto.getItemAnn();
        System.out.println("goodsAnnouncementDto = "+ goodsAnnouncementDto);

        log.info("searchKeyword={}",searchKeywordDto);

        productsCreateService.write(goodsDto);
        productsCreateService.writeAnnouncement(goodsAnnouncementDto);
        productsCreateService.writeKeyword(searchKeywordDto);

        return "redirect:/seller/productsCreate";
        //나중에 상품 등록 확인 페이지 만들고 연결하기
    }



}
