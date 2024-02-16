package com.brokurly.repository;

import com.brokurly.domain.FAQCate;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FAQCateDao {
    List<FAQCate> selectFAQCateList();
}
