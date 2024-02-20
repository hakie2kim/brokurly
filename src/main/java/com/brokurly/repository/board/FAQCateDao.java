package com.brokurly.repository.board;

import com.brokurly.entity.board.FAQCate;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FAQCateDao {
    List<FAQCate> selectFAQCateList();
}
