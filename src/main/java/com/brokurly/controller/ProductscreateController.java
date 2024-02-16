package com.brokurly.controller;


import com.brokurly.dto.GoodsDto;
import com.brokurly.dto.ItemAnnouncementDto;
import com.brokurly.service.ProductscreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/seller")
public class ProductscreateController {
   ProductscreateService productscreateService;

    @Autowired
    public ProductscreateController(ProductscreateService productscreateService){
        this.productscreateService = productscreateService;
    }

    @PostMapping("/productscreate/write")
    public String writeproducts(GoodsDto goodsDto, ItemAnnouncementDto itemAnnouncementDto){
        String a = goodsDto.getName();
        log.info("a={}",a);
        System.out.println(goodsDto);

        String b = itemAnnouncementDto.getItemAnn();
        System.out.println("itemAnnouncementDto = "+itemAnnouncementDto);


        productscreateService.write(goodsDto);
        productscreateService.writeAnnouncement(itemAnnouncementDto);

        return "redirect:/seller/productscreate";
        //나중에 상품 등록 확인 페이지 만들고 연결하기
    }

}
