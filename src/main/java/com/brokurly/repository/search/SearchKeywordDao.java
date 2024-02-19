package com.brokurly.repository.search;


import com.brokurly.entity.search.SearchKeyword;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchKeywordDao {

    void insert(SearchKeyword searchKeyword);
}
