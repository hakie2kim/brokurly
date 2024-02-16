package com.brokurly.repository;

import com.brokurly.domain.FAQBoard;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FAQBoardDao {
    List<FAQBoard> selectFAQList();
}
