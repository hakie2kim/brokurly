package com.brokurly.service;

import com.brokurly.dto.CategoryDto;
import com.brokurly.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

 CategoryDao categoryDao;

 //생성자 추가해서 주입받기
 @Autowired
public CategoryService(CategoryDao categoryDao){
 this.categoryDao = categoryDao;
}


 //카테고리 대분류 가져오기
public List<CategoryDto> readMain() throws Exception{
 return categoryDao.selectMainExp();
}

}
