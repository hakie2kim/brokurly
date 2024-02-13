package com.brokurly.service;

import com.brokurly.entity.NoticeBoardDto;
import com.brokurly.entity.NoticeListDto;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Map;

@Service
public interface NoticeService {

//    noticelist 띄우기
//    noticeboard 띄우기
    List<NoticeListDto> getList() throws Exception;

    NoticeListDto read(Integer bno) throws Exception;

    List<NoticeListDto> getPage(Map map) throws Exception;
    NoticeBoardDto getBoard(int bno) throws Exception;
}