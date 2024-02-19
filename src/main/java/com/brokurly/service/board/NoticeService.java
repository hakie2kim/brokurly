package com.brokurly.service.board;

import com.brokurly.entity.board.Notice;
import com.brokurly.dto.board.NoticeBoardDto;
import com.brokurly.dto.board.NoticeListDto;
import com.brokurly.repository.board.NoticeBoardDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeBoardDao noticeBoardDao;

    //  스트림 사용하면 간편하게 할 수 있다.
    public List<NoticeListDto> getList() {
        List<Notice> noticeList = noticeBoardDao.selectAllPages();
        List<NoticeListDto> noticeListDtoList = new ArrayList<>();
        for (Notice notice : noticeList) {
            noticeListDtoList.add(notice.getNoticeListDto());
        }
        return noticeListDtoList;
    }

    public NoticeBoardDto getBoard(int bno) {
        Notice notice = noticeBoardDao.selectBoardDetail(bno);
        return notice.getNoticeBoardDto();
    }

}