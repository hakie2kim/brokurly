package com.brokurly.controller.categories;

import com.brokurly.dto.categories.CategoryDto;
import com.brokurly.service.categories.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class BestPageController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/header")
    public String readCategory(Model m) throws Exception {

//        CategoryDto categoryDto = new CategoryDto();

        List<CategoryDto> selectMain = categoryService.readMain();
        m.addAttribute("selectMain", selectMain);


        return "/categories/header";
    }

    @GetMapping("/best-page")
    public String bestpage(Model m) throws Exception {
//        CategoryDto categoryDto = new CategoryDto();

        List<CategoryDto> selectMain = categoryService.readMain();
        m.addAttribute("selectMain", selectMain);

        return "categories/best-page";
    }

}