package com.brokurly.repository.categories;

import com.brokurly.entity.categories.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
    int insert(Category category);

    int deletebyId (String codeId);

    void deleteAll();

    //    카테고리 대분류 가져오기
    List<Category> selectPrimary();

    List<Category> getCategoryExpByPrimary(String codeId);

}
