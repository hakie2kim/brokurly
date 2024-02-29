package com.brokurly.service.board;

import com.brokurly.entity.board.FAQBoard;
import com.brokurly.entity.board.FAQCate;
import com.brokurly.dto.board.FAQListDto;
import com.brokurly.repository.board.FAQCateDao;
import com.brokurly.repository.board.FAQBoardDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FAQService {
    private final FAQBoardDao faqBoardDao;
    private final FAQCateDao faqCateDao;
    private static final int NUMBER_PER_PAGE = 15;

    public List<FAQListDto> getFaqList(@RequestParam Integer page) {
        if (page == null) {page = 0;}
        List<FAQBoard> faqBoardList = faqBoardDao.selectFAQList(page * NUMBER_PER_PAGE, NUMBER_PER_PAGE);
        List<FAQCate> faqCateList = faqCateDao.selectFAQCateList();
        return new FAQBoard().pleasejoin(faqBoardList, faqCateList);
    }
}
