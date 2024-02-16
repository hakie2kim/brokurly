package com.brokurly.service;

import com.brokurly.domain.FAQBoard;
import com.brokurly.domain.FAQCate;
import com.brokurly.dto.FAQListDto;
import com.brokurly.repository.FAQCateDao;
import com.brokurly.repository.FAQBoardDao;
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
