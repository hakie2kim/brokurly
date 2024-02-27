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
            , GoodsImageDto goodsImageDto) {
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
        productsCreateService.writeGoodsImage(goodsImageDto);

        return "seller/productsOriginList?bsnsNo=";
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

//    @PostMapping("/uploadAjaxAction")
//    public void uploadAjaxAction(MultipartFile[] uploadFile){
//        log.info("uploadAjaxActionPOST.......");
////        log.info("파일 이름 : " + uploadFile.getOriginalFilename());
////        log.info("파일 타입 : " + uploadFile.getContentType());
////        log.info("파일 크기 : " + uploadFile.getSize());
//        String uploadFolder = "/Users/sookyung/Desktop/kurlyimg";
//
//        //날짜 폴더 경로
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date();
//        String str = sdf.format(date);
//        String datePath = str.replace("-", File.separator);
//
////        폴더 생성
//        File uploadPath = new File(uploadFolder, datePath);
//
//        if(uploadPath.exists() == false) {
//            uploadPath.mkdirs();
//        }
//        for(MultipartFile multipartFile : uploadFile){
////            파일 이름
//            String uploadFileName = multipartFile.getOriginalFilename();
//
////          uuid 적용 파일 이름
//            String uuid = UUID.randomUUID().toString();
//            uploadFileName = uuid+"_"+uploadFileName;  //파일 이름 중복 피하기 위해
//            log.info("uuid={}",uploadFileName);
////            파일 위치, 파일 이름을 합친 File객체
//            File saveFile = new File(uploadPath, uploadFileName);
////            파일 저장
//            try{
//                multipartFile.transferTo(saveFile);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }

    @PostMapping("/img")
    public String saveFile(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("request={}",file);
        String uploadDir = "/Users/sookyung/Desktop/kurlyimg";
//        String itemName = file.toString();
//        log.info("itemName={}",itemName);
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            log.info("file.getOriginalFilename={}",filename);

            String fullpath = uploadDir + filename;
            file.transferTo(new File(fullpath));
        }

        //1. 파일 저장하기

        //2. url 서비스로 보내기

        return "upload-form";
    }

}
