package com.brokurly.repository;

import com.brokurly.entity.CategoryDto;
import com.brokurly.entity.CategoryMainDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
    void insert(CategoryDto categoryDto);

//    카테고리 대분류 가져오기
    List<CategoryMainDto> selectMainExp();

//    907 중분류
    List<CategoryDto> select907();
}
