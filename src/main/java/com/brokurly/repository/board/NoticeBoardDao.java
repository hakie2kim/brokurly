package com.brokurly.repository.board;

import com.brokurly.entity.board.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeBoardDao {
    List<Notice> selectAllPages();
    Notice selectBoardDetail(int bno);
}