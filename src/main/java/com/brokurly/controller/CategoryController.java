package com.brokurly.controller;

import com.brokurly.dto.CategoryDto;
import com.brokurly.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/seller")
public class CategoryController {

   CategoryService categoryService;

    //생성자 추가해서 주입받기
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/productscreate")
    public String readCategory(Model m) throws Exception {

//        CategoryDto categoryDto = new CategoryDto();

        List<CategoryDto> selectMain = categoryService.readPrimary();
        m.addAttribute("selectMain", selectMain);
        log.info("model={}",m);
        log.info("selectMain={}", selectMain);

        return "/seller/productscreate";
    }

    @PostMapping ("/ajax")
    public void test(@RequestParam String testcodeId){

        log.info("testcodeId={}",testcodeId);

//        m.addAttribute("code_id", categoryDto.getCodeId());

    }



}
