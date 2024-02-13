package com.brokurly.service;

import com.brokurly.entity.NoticeBoardDto;
import com.brokurly.entity.NoticeListDto;
import com.brokurly.repository.NoticeBoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeBoardDao noticeBoardDao;
    @Override
    public List<NoticeListDto> getList() throws Exception {
        return noticeBoardDao.selectAllPages();
    }

    @Override
    public NoticeBoardDto getBoard(int bno) throws Exception {
        return noticeBoardDao.selectBoardDetail(bno);
    }

    @Override
    public NoticeListDto read(Integer bno) throws Exception {
        return null;
    }

    @Override
    public List<NoticeListDto> getPage(Map map) throws Exception {
        return null;
    }
}