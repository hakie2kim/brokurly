package com.brokurly.controller.products;


import com.brokurly.dto.categories.CategoryDto;
import com.brokurly.dto.goods.*;
import com.brokurly.dto.search.SearchKeywordDto;
import com.brokurly.dto.seller.SellerAndLoginDto;
import com.brokurly.service.categories.CategoryService;
import com.brokurly.service.products.ProductsCreateService;
import com.brokurly.service.seller.SellerService;
import com.brokurly.utils.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
public class ProductsCreateController {

    private final ProductsCreateService productsCreateService;
    private final CategoryService categoryService;
    private final SellerService sellerService;


    @PostMapping("/productsCreate/write")
    public String writeProducts(@Valid GoodsDto goodsDto, BindingResult bindingResult,
                                Model m, GoodsAnnouncementDto goodsAnnouncementDto, SearchKeywordDto searchKeywordDto
    ) {
        if (bindingResult.hasErrors()){
            log.info("상품 등록 실패");
            return "productsCreate";
        }
        String a = goodsDto.getName();
        m.addAttribute("mode", "new");
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

        //판매자 상품조회페이지로.
        return "redirect:/seller/productsOriginList";
    }

    @PostMapping("/productsCreate/modify")
    public String modify(GoodsUpdateDto goodsUpdateDto, String itemId, Model m){
        log.info("goodsDto={}", goodsUpdateDto);
        log.info("itemId={}", itemId);

        productsCreateService.updateGoods(itemId,goodsUpdateDto);
        return "redirect:/seller/productsOriginList";
    }


    @GetMapping("/productsOriginList")
    public String selectByBsnsId(Model m, HttpServletResponse res, HttpServletRequest req) {

        HttpSession session = req.getSession();
        SellerAndLoginDto nameDto = (SellerAndLoginDto) session.getAttribute(SessionConst.LOGIN_SELLER);
        if(nameDto!=null){

            //1. 세션에서 id 불러오기
            log.info("nameDto={}",nameDto);
            String nameDtoId = nameDto.getId();

            //2. id로 bsnsNo찾기
            String bsnsNo =sellerService.selectBsnsNo(nameDtoId).getBsnsNo();
            log.info("bnsnNo={}",bsnsNo);


            List<GoodsByBsnsNoDto> goodsByBsnsNoDtosList = productsCreateService.readByBsnsNo(bsnsNo);
            m.addAttribute("goodsByBsnsNo", goodsByBsnsNoDtosList);
            m.addAttribute("goodssize", goodsByBsnsNoDtosList.size());
//        log.info("m={}", m);
            return "seller/productsOriginList";

        } else {
            return "/seller/loginForm";
        }
    }


    @GetMapping("/productsCreate/read")
    public String read(String itemId, Model m) {
        GoodsDto goodsDto = productsCreateService.searchGoods(itemId);
        GoodsAnnouncementDto goodsAnnouncementDto = productsCreateService.searchAnnouncement(itemId);
        List<String> searchKeyword = productsCreateService.searchKeyword(itemId);

        List<CategoryDto> selectPrimary = categoryService.readPrimary();
        m.addAttribute("selectMain", selectPrimary);

        log.info("GoodsAnnouncementDto={}", goodsAnnouncementDto);
        log.info("readItemId={}", itemId);
        log.info("searchKeyword={}", searchKeyword);

        //상품고시정보 ,로 잘라서 배열로 만들기
        String[] anno = goodsAnnouncementDto.getItemAnn().split(",");
//        for (int i = 0; i < anno.length; i++) {
//            log.info("anno={}", anno[i]);
//        }

//        m.addAttribute("mode","readonly");
        m.addAttribute("goodsDto", goodsDto);
        m.addAttribute("goodsAnnouncement", anno);
        m.addAttribute("keyword", searchKeyword);


        return "seller/productsCreate";  //읽기
    }


    //상품 등록 정보 삭제
    @RequestMapping(value = "/productsCreate/remove",method = RequestMethod.GET)
    public String removeProducts(String itemId) throws Exception {

        log.info("removeitemId={}", itemId);
        int result = productsCreateService.removeByItemId(itemId);
        if(result!=1)//1이 아니라면 예외 발생
            throw new Exception("board remove error");

        //삭제된 후 다시 판매자 bsnsNo에 맞는 페이지로
        return "redirect:/seller/productsOriginList";
    }


    @PostMapping("/img")
    public void saveFile(@RequestParam("file") MultipartFile file, GoodsImageDto goodsImageDto) throws IOException {
        log.info("request={}", file);
        String uploadDir = "/Users/sookyung/Desktop/kurlyimg/"; //파일 저장 경로
//        String uploadDir = System.getProperty("user.dir") + "/src/main/webapp/resources/image/goodsImg/"; //파일 저장 경로
//        String uploadDir =  "resources/image/goodsImg/"; //파일 저장 경로

        // "goodsImage" 디렉토리에 파일 저장
//        Resource resource = resourceLoader.getResource("classpath:/static/goodsImage/");
//        Resource resource = resourceLoader.getResource("classpath:/static/goodsImage/");
//        String uploadDir = resource.getFile().getAbsolutePath();

        if (!file.isEmpty()) {

//            // 파일 이름
//            String filename = file.getOriginalFilename();
//            String filename2 = file.toString();
//
//            String fullpath = uploadDir + filename;
//
//            log.info("file.getOriginalFilename={}",filename);
//            log.info("file.getResource={}",filename2);
//
////          uuid 적용 파일 이름
//            String uuid = UUID.randomUUID().toString();
//            filename = uuid+"_"+filename;  //파일 이름 중복 피하기 위해
//            log.info("uuid={}",filename);
//////         파일 위치, 파일 이름을 합친 File객체
//            File saveFile = new File(fullpath, filename);
//
//            //1. 파일 저장하기
//            file.transferTo(saveFile);
//
//            //2. url 서비스로 보내기
//            log.info("GoodsImageDto={}",goodsImageDto.toString());
//            productsCreateService.writeGoodsImage(goodsImageDto);

            // 파일 이름
            String originalFilename = file.getOriginalFilename();

            // UUID 적용 파일 이름
            String uuid = UUID.randomUUID().toString();
            String filename = uuid + "_" + originalFilename; // 파일 이름 중복 피하기 위해

            // 파일 위치, 파일 이름을 합친 File 객체
            File saveFile = new File(uploadDir + filename);

            // 1. 파일 저장하기
            file.transferTo(saveFile);

            // 2. url 서비스로 보내기
            String fileUrl = "/files/" + filename; // 예시: "/files/filename"
            log.info("File URL: {}", fileUrl);

            // 여기서 fileUrl을 활용하여 필요한 작업을 수행하면 됩니다.
            // 예를 들면, goodsImageDto에 파일 URL을 저장하거나 다른 서비스로 전송하는 등의 작업이 가능합니다.

            log.info("GoodsImageDto={}", goodsImageDto.toString());
            productsCreateService.writeGoodsImage(goodsImageDto);

        }

    }

//
//    @PostMapping("/img")
//    @ResponseBody
//    public HttpStatus upload(@RequestParam("file") MultipartFile multipartFile) {
//        log.info("file = {}", multipartFile);
//        try {
//            // 현재 프로젝트의 절대 경로를 가져옵니다
//            String projectPath = System.getProperty("user.dir");
////                    + File.separator + "IdeaProjects" +
////                    File.separator + "brokurly";
//
////            FileCopyUtils.copy(mfile.getInputStream(), new FileOutputStream(Paths.get(saveFileName).toFile()));
//
//            log.info("dir = {}", projectPath);
//
//            // 이미지를 저장할 폴더의 경로를 지정합니다
//            String uploadDir = projectPath +
//                    File.separator + "src" +
//                    File.separator + "main" +
//                    File.separator + "webapp" +
//                    File.separator + "resources" +
//                    File.separator + "image" +
//                    File.separator + "goodsImage";
//
//            log.info("projectPath = {}, uploadDir = {}", projectPath, uploadDir);
//
//            // 만약 해당 경로에 폴더가 없다면 폴더를 생성합니다
//            File dir = new File(uploadDir);
//            if (!dir.exists()) dir.mkdirs();
//
//            // 파일 이름을 정의합니다
//            String originalFilename = multipartFile.getOriginalFilename();
//            String filePath = uploadDir + File.separator + UUID.randomUUID()  + "_" + originalFilename;
//
//            Path savePath = Paths.get(filePath);
//
//            // 파일을 저장합니다
//            multipartFile.transferTo(savePath);
//
//            log.info("filename={}",filePath);
//
//            // 파일의 저장 경로를 반환합니다
//            return HttpStatus.OK;
//        } catch (IOException e) {
//            // 파일 저장 중 에러가 발생했을 경우 에러 메시지를 반환합니다
//            return HttpStatus.SERVICE_UNAVAILABLE;
//        }
//    }

}
