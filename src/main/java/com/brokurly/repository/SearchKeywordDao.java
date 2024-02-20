package com.brokurly.repository;


import com.brokurly.domain.SearchKeyword;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchKeywordDao {

    int insert(SearchKeyword searchKeyword);
}
