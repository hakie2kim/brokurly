package com.brokurly.repository;

import com.brokurly.domain.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeBoardDao {
    List<Notice> selectAllPages();
    Notice selectBoardDetail(int bno);
}