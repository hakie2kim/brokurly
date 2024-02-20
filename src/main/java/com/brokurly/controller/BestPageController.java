package com.brokurly.controller;

import com.brokurly.domain.Category;
import com.brokurly.dto.CategoryDto;

import com.brokurly.dto.GoodsListDto;
import com.brokurly.service.CategoryService;

import com.brokurly.service.GoodsListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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

    @RequestMapping(value = "/{codeId}", method = RequestMethod.GET)
    public String categoryPage(Model m, @PathVariable String codeId) throws Exception{

        categoryService.readPrimary();

        List<CategoryDto> selectMain = categoryService.readPrimary();
        m.addAttribute("selectMain", selectMain);


        List<CategoryDto> categorydto = categoryService.findCategoryByPrimary(codeId);
        List<GoodsListDto> goodsListDto = goodsListService.readGoodsList(codeId);



        m.addAttribute("codeId",codeId);

        m.addAttribute("categorydto",categorydto);
        m.addAttribute("goodsListDto",goodsListDto);




        return "categories/categories";

    }

}
