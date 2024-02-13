package com.brokurly.service;

import com.brokurly.entity.FAQListDto;
import com.brokurly.repository.FAQDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQService {
    @Autowired
    FAQDao faqDao;

    public List<FAQListDto> getFaqList() {
        return faqDao.selectFAQList();
    }


}
