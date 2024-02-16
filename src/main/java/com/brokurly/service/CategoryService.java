package com.brokurly.service;

import com.brokurly.domain.Category;
import com.brokurly.dto.CategoryDto;
import com.brokurly.repository.CategoryDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CategoryService {
    private final CategoryDao categoryDao;

    //생성자 추가해서 주입받기
    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    //카테고리 대분류 가져오기
    @Transactional
    public List<CategoryDto> readMain() {
        //domain list 전체 가져오기
        List<Category> categoryList = categoryDao.selectMain();

        //비어있는 dtoList 만들기
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        //비어있는 dto list에 domain을 하나씩 넣는다.
        for (Category category : categoryList) {
            categoryDtoList.add(category.makeFullDto());
        }

        log.info("list={}", categoryDtoList);

        return categoryDtoList;
    }

    // 카테고리 중분류 가져오기
    @Transactional
    public List<CategoryDto> readMiddle(@RequestParam String codeId) {
        //domain list에 담아서
        List<Category> categoryList = categoryDao.selectMiddle(codeId);
        //비어있는 list 만들기
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        //domain 하나씩 넣기
        for(Category category : categoryList){
            categoryDtoList.add(category.makeFullDto());
        }
        log.info("Middlelist서비스={}",categoryDtoList);

        return categoryDtoList;
    }


}
