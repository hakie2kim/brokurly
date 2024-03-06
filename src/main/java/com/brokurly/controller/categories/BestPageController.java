package com.brokurly.controller.categories;

import com.brokurly.dto.categories.CategoryDto;
import com.brokurly.dto.goods.GoodsListDto;
import com.brokurly.service.goods.GoodsListService;
import com.brokurly.service.categories.CategoryService;
import com.brokurly.utils.PageHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


        return "include/header";
    }

    @GetMapping("/best-page")
    public String bestpage(Model m) throws Exception {
//        CategoryDto categoryDto = new CategoryDto();

        List<CategoryDto> selectMain = categoryService.readPrimary();
        m.addAttribute("selectMain", selectMain);

        return "categories/best-page";
    }

    @RequestMapping(value = "/{codeId}", method = RequestMethod.GET)
    public String categoryPage(Model m, @PathVariable String codeId,
                               @RequestParam(required = false) String sortedType,
                               @RequestParam(required = false) Integer page,
                               @RequestParam(required = false) String filters
                                ) throws Exception {
        log.info("filters = {}", filters);

        //대분류 카테고리이름
        categoryService.readPrimary();
        List<CategoryDto> selectMain = categoryService.readPrimary();
        m.addAttribute("selectMain", selectMain);

        //페이징
        int totalCnt = goodsListService.countGoodsList(codeId);
        PageHandler pageHandler = new PageHandler(totalCnt, page);

        //중분류 카테고리이름
        List<CategoryDto> categorydto = categoryService.findCategoryByPrimary(codeId.length() == 6 ? codeId.substring(0, 3) : codeId);

        // 카테고리별 & 분류 타입에 따라 상품 나열하기
        List<GoodsListDto> goodsListDto = new ArrayList<>();
        if(filters !=null) {
            if (sortedType != null) {
                goodsListDto = goodsListService.sortGoodsList(codeId, page, sortedType);
            } else {
                if (page == null) page = 1;
                goodsListDto = goodsListService.readGoodsList(codeId, page);
            }
        }
        else{
            if (sortedType != null) {
                goodsListDto = goodsListService.sortGoodsList(codeId, page, sortedType);
            } else {
                if (page == null) page = 1;
                goodsListDto = goodsListService.readGoodsList(codeId, page);
            }
        }

        //필터=배송타입일때
        //필터=가격일때
        //필터=배송&가격 둘다 있을떄



        m.addAttribute("codeId", codeId);
        m.addAttribute("sortedType", sortedType);

        m.addAttribute("categorydto", categorydto);
        m.addAttribute("goodsListDto", goodsListDto);
        m.addAttribute("totalCnt", totalCnt);
        m.addAttribute("ph", pageHandler);


        return "categories/categories";

    }
}
