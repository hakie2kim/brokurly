package com.brokurly.repository;

import com.brokurly.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
    void insert(CategoryDto categoryDto);

//    카테고리 대분류 가져오기
    List<CategoryDto> selectMain();


}
