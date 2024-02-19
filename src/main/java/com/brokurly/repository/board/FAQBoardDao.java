package com.brokurly.repository.board;

import com.brokurly.entity.board.FAQBoard;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FAQBoardDao {
    List<FAQBoard> selectFAQList();
}
