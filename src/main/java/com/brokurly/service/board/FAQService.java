package com.brokurly.service.board;

import com.brokurly.entity.board.FAQBoard;
import com.brokurly.entity.board.FAQCate;
import com.brokurly.dto.board.FAQListDto;
import com.brokurly.repository.board.FAQCateDao;
import com.brokurly.repository.board.FAQBoardDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FAQService {
    private final FAQBoardDao faqBoardDao;
    private final FAQCateDao faqCateDao;


    public List<FAQListDto> getFaqList() {
        List<FAQBoard> faqBoardList =  faqBoardDao.selectFAQList();
        List<FAQCate> faqCateList =  faqCateDao.selectFAQCateList();
        return new FAQBoard().pleasejoin(faqBoardList, faqCateList);
    }
}
