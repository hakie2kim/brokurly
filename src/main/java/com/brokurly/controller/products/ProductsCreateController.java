package com.brokurly.controller.products;


import com.brokurly.dto.goods.GoodsAnnouncementDto;
import com.brokurly.dto.goods.GoodsByBsnsNoDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsImageDto;
import com.brokurly.dto.search.SearchKeywordDto;
import com.brokurly.service.goods.GoodsService;
import com.brokurly.service.products.ProductsCreateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.http.Multipart;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping("/seller")
public class ProductsCreateController {

    private ProductsCreateService productsCreateService;

    @Autowired
    public ProductsCreateController(ProductsCreateService productsCreateService) {
        this.productsCreateService = productsCreateService;
    }

    @PostMapping("/productsCreate/write")
    public String writeproducts(Model m, GoodsDto goodsDto, GoodsAnnouncementDto goodsAnnouncementDto, SearchKeywordDto searchKeywordDto
            ) {
        String a = goodsDto.getName();
        m.addAttribute("mode","new");
        log.info("a={}", a);

        log.info("goodsDto={}", goodsDto);

        log.info("itemId={}", goodsDto.getItemId());

//        String b = goodsAnnouncementDto.getItemAnn();
        System.out.println("goodsAnnouncementDto = " + goodsAnnouncementDto);

        log.info("searchKeyword={}", searchKeywordDto);

        productsCreateService.write(goodsDto);
        productsCreateService.writeAnnouncement(goodsAnnouncementDto);
        productsCreateService.writeKeyword(searchKeywordDto);
//        productsCreateService.writeGoodsImage(goodsImageDto);

        return "seller/productsOriginList";
        //나중에 상품 등록 확인 페이지 만들고 연결하기
    }

//    @GetMapping("/write")
//    public String write(Model m){
//        m.addAttribute("mode"
//        ,"new");
//        return "productsCreate"; //쓰기
//    }

//    @GetMapping("/read")
//    public String read(String itemId, Model m){
//        GoodsDto goodsDto = goodsService.searchGoods(itemId);
//        log.info("goodsDto??={}",goodsDto);
//        m.addAttribute("goodsDto",goodsDto);
//        return "productsCreate";  //읽기
//    }


    @GetMapping("productsOriginList")
    public String selectByBsnsId(Model m) {
        String bsnsNo = "4659877658";  //판매자 로그인 기능 구현 후 세션에서 가져오기
//    log.info("goodsByBsnsNoDto={}",goodsByBsnsNoDto);
        List<GoodsByBsnsNoDto> goodsByBsnsNoDtosList = productsCreateService.readByBsnsNo(bsnsNo);
        m.addAttribute("goodsByBsnsNo", goodsByBsnsNoDtosList);
        m.addAttribute("goodssize", goodsByBsnsNoDtosList.size());
        log.info("m={}", m);
        return "seller/productsOriginList";
    }


    @GetMapping("/productsOriginList/read")
    public String read(String itemId, Model m) {
        GoodsDto goodsDto = productsCreateService.searchGoods(itemId);
//        GoodsAnnouncement goodsAnnouncement = goodsService.
//        log.info("goodsDto??={}", goodsDto);
        m.addAttribute("goodsDto", goodsDto);

        return "seller/productsCreate";  //읽기
    }


    @PostMapping("/img")
    @ResponseBody
    public void saveFile(@RequestParam("file")MultipartFile file ,GoodsImageDto goodsImageDto ) throws IOException {
        log.info("request={}",file);
        String uploadDir = "/Users/sookyung/Desktop/kurlyimg/"; //파일 저장 경로
        if(!file.isEmpty()){

            // 파일 이름
            String filename = file.getOriginalFilename();
            String filename2 = file.toString();

            String fullpath = uploadDir + filename;

            log.info("file.getOriginalFilename={}",filename);
            log.info("file.getResource={}",filename2);

//          uuid 적용 파일 이름
            String uuid = UUID.randomUUID().toString();
            filename = uuid+"_"+filename;  //파일 이름 중복 피하기 위해
            log.info("uuid={}",filename);
////         파일 위치, 파일 이름을 합친 File객체
            File saveFile = new File(fullpath, filename);

            //1. 파일 저장하기
            file.transferTo(saveFile);

            //2. url 서비스로 보내기
            log.info("GoodsImageDto={}",goodsImageDto.toString());
            productsCreateService.writeGoodsImage(goodsImageDto);


        }

    }

}
