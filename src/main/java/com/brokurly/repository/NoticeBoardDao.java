package com.brokurly.repository;

import com.brokurly.entity.Notice;
import com.brokurly.entity.NoticeBoardDto;
import com.brokurly.entity.NoticeListDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NoticeBoardDao {
    List<NoticeListDto> selectAllPages();

    void insert(Notice notice);
    NoticeBoardDto selectBoardDetail(int bno);

}