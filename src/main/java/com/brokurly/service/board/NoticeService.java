package com.brokurly.service.board;

import com.brokurly.entity.board.Notice;
import com.brokurly.dto.board.NoticeBoardDto;
import com.brokurly.dto.board.NoticeListDto;
import com.brokurly.repository.board.NoticeBoardDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeBoardDao noticeBoardDao;

    private static final int NUMBER_PER_PAGE = 15;

    public List<NoticeListDto> getList(@RequestParam Integer page) {
        if (page == null) {page = 0;}
        List<Notice> noticeList = noticeBoardDao.selectPage(page * NUMBER_PER_PAGE, NUMBER_PER_PAGE);
        List<NoticeListDto> noticeListDtoList = new ArrayList<>();
        for (Notice notice : noticeList) {
            noticeListDtoList.add(notice.getNoticeListDto());
        }
        return noticeListDtoList;
    }
//    public List<NoticeListDto> getList(Integer bno) {
////        만약 첫페이지, 최초의 bno가 없는 상황이라면 전체테이블의 가장 최신 글의 번호를 받아와 bno에 넣어준다.
////        if (bno == null) {
////            bno = noticeBoardDao.selectMax().getBno();
////        }
//
//
//        log.info("bno = {}", bno);
////        그릐고 받아온 bno부터 bno - 14 번까지의 notice 도메인을 받아온다.
//        List<Notice> noticeList = noticeBoardDao.selectPage(bno);
//        log.info("noticelistSize = {} ", noticeList.size());
//        log.info("{}", noticeList);
////        받아온 domain에서 페이지를 보여주기위한 데이터만 Dto에 담는다.
//        List<NoticeListDto> noticeListDtoList = new ArrayList<>();
////        List니까 반복문
//        for (Notice notice : noticeList) {
//            noticeListDtoList.add(notice.getNoticeListDto());
//        }
//        return noticeListDtoList;
//    }

//       스트림 사용하면 간편하게 할 수 있다.
//    public List<NoticeListDto> getList() {
//        List<Notice> noticeList = noticeBoardDao.selectAllPages();
//        List<NoticeListDto> noticeListDtoList = new ArrayList<>();
//        for (Notice notice : noticeList) {
//            noticeListDtoList.add(notice.getNoticeListDto());
//        }
//        return noticeListDtoList;
//    }

    public NoticeBoardDto getBoard(int bno) {
        Notice notice = noticeBoardDao.selectBoardDetail(bno);
        return notice.getNoticeBoardDto();
    }

}