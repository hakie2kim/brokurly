package com.brokurly.service;

import com.brokurly.entity.CategoryDto;
import com.brokurly.entity.CategoryMainDto;
import com.brokurly.repository.CategoryDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
@Autowired
CategoryDao categoryDao;

//카테고리 대분류 가져오기
public List<CategoryMainDto> readMain() throws Exception{
 return categoryDao.selectMainExp();
}

// 카테고리 907 중분류 가져오기
public List<CategoryDto> read907() throws Exception{
 return categoryDao.select907();
}

}
