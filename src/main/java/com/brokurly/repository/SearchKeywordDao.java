package com.brokurly.repository;

import com.brokurly.entity.SearchKeyword;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchKeywordDao {

    void insert(SearchKeyword searchKeyword);
}
