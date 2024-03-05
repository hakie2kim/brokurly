package com.brokurly.controller.categories;

import com.brokurly.dto.categories.CategoryDto;
import com.brokurly.dto.goods.GoodsListDto;
import com.brokurly.service.goods.GoodsListService;
import com.brokurly.service.categories.CategoryService;
import com.brokurly.utils.PageHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/categories")
public class BestPageController {

    private final CategoryService categoryService;
    private final GoodsListService goodsListService;

    @GetMapping("/header")
    public String readCategory(Model m) throws Exception {

        categoryService.readPrimary();

        List<CategoryDto> selectMain = categoryService.readPrimary();
        m.addAttribute("selectMain", selectMain);


        return "/categories/header";
    }

    @GetMapping("/best-page")
    public String bestpage(Model m) throws Exception {
//        CategoryDto categoryDto = new CategoryDto();

        List<CategoryDto> selectMain = categoryService.readPrimary();
        m.addAttribute("selectMain", selectMain);

        return "categories/best-page";
    }

    @GetMapping("/{codeId}")
    public String categoryPage(Model model, @PathVariable String codeId,
                               @RequestParam(required = false) String sortedType,
                               @RequestParam(required = false) Integer page,
                               @RequestParam(required = false) String filters) throws Exception {

        log.info("filters = {}", filters);

        //대분류 카테고리이름
        categoryService.readPrimary();
        List<CategoryDto> selectMain = categoryService.readPrimary();
        model.addAttribute("selectMain", selectMain);

        //페이징
        int totalCnt = goodsListService.countGoodsList(codeId);
        PageHandler pageHandler = new PageHandler(totalCnt, page);

        //중분류 카테고리이름
        List<CategoryDto> categorydto = categoryService.findCategoryByPrimary(codeId.length() == 6 ? codeId.substring(0, 3) : codeId);

        // 카테고리별 & 분류 타입에 따라 상품 나열하기
        List<GoodsListDto> goodsListDto;
        if (page == null) page = 1;
        if (sortedType != null) {
            goodsListDto = goodsListService.sortGoodsList(codeId, page, sortedType);
        } else {
            goodsListDto = goodsListService.readGoodsList(codeId, page);
        }

        //필터=배송타입일때
        //필터=가격일때
        //필터=배송&가격 둘다 있을떄

        model.addAttribute("codeId", codeId);
        model.addAttribute("sortedType", sortedType);

        model.addAttribute("categorydto", categorydto);
        model.addAttribute("goodsListDto", goodsListDto);
        model.addAttribute("totalCnt", totalCnt);
        model.addAttribute("pageHandler", pageHandler);

        return "categories/categories";
    }

    @PostMapping("/{codeId}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> categoryPageAjax(Model model, @PathVariable String codeId,
                                                                @RequestParam(required = false) String sortedType,
                                                                @RequestParam(required = false) Integer page,
                                                                @RequestParam(required = false) String filters) {

        log.info("codeId = {}", codeId);
        log.info("sortedType = {}", sortedType);

        Map<String, Object> responseMap = new HashMap<>();
        List<GoodsListDto> sortedGoodsList = goodsListService.sortGoodsList(codeId, page, sortedType);
        log.info("sortedGoodsList={}", sortedGoodsList);
        responseMap.put("sortedGoodsList", sortedGoodsList);
        log.info("responseMap ={}", responseMap);

        int totalCnt = goodsListService.countGoodsList(codeId);
        PageHandler pageHandler = new PageHandler(totalCnt, page);
        responseMap.put("pageHandler", pageHandler);
        log.info("pageHandler={}", pageHandler);

        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}
