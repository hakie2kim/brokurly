package com.brokurly.service;

import com.brokurly.domain.Category;
import com.brokurly.dto.CategoryDto;
import com.brokurly.repository.CategoryDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CategoryService {

 CategoryDao categoryDao;

 //생성자 추가해서 주입받기
 @Autowired
 public CategoryService(CategoryDao categoryDao) {
  this.categoryDao = categoryDao;
 }


 //카테고리 대분류 가져오기
 public List<CategoryDto> readPrimary() {

  List<Category> categoryList = categoryDao.selectPrimary();
  List<CategoryDto> categoryDto =new ArrayList<>(); //빈공간을 만든다

  for (Category category : categoryList) { //categoryList에서 Category(도메인)를 하나씩 꺼내서
   categoryDto.add(category.makeDto());    //makeDto메서드를 이용해 Dto로 만들어
  }                                        //categoryDtoList에 다시 담는다
  log.info("{}",categoryDto);
  return categoryDto;

 }


 public List<CategoryDto> findCategoryByPrimary(String codeId) {

  List<Category> categoryList = categoryDao.getCategoryExpByPrimary(codeId);
  List<CategoryDto> categoryDto =new ArrayList<>();

   for (Category category : categoryList) { //categoryList에서 Category(도메인)를 하나씩 꺼내서
    categoryDto.add(category.makeDto());    //makeDto메서드를 이용해 Dto로 만들어
   }                                        //categoryDtoList에 다시 담는다
  log.info("{}",categoryDto);
  return categoryDto;


 }


}
