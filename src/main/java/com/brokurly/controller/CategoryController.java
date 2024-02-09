package com.brokurly.controller;

import com.brokurly.entity.CategoryDto;
import com.brokurly.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/seller")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/productscreate")
    public String readCategory(Model m) throws Exception {

        CategoryDto categoryDto = new CategoryDto();


        List<CategoryDto> selectMain = categoryService.readMain();
        m.addAttribute("selectMain", selectMain);
        log.info("model={}",m);
        log.info("selectMain={}", selectMain);

        return "/seller/productscreate";
    }

}
