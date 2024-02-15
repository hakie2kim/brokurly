package com.brokurly.repository;
import com.brokurly.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {

//    카테고리 대분류 가져오기
    List<Category> selectMain();

    List<Category> selectMiddle(String testcodeId);

}
