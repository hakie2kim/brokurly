package com.brokurly.repository;
import com.brokurly.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface CategoryDao {

//    카테고리 대분류 가져오기
    List<Category> selectMain();

    //카테고리 중분류 가져오기
    List<Category> selectMiddle(@RequestParam String codeId);

}
