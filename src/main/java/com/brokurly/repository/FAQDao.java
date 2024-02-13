package com.brokurly.repository;

import com.brokurly.entity.FAQListDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FAQDao {
    List<FAQListDto> selectFAQList();
}
