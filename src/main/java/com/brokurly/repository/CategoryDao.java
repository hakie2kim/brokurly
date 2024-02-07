package com.brokurly.repository;

import com.brokurly.entity.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
void insert(CategoryDto categoryDto);
//CategoryDto selectmainexp();
List<CategoryDto> select907();
}
