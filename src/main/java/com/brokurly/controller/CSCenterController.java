package com.brokurly.controller;

import com.brokurly.entity.NoticeBoardDto;
import com.brokurly.entity.NoticeListDto;
import com.brokurly.entity.FAQListDto;
import com.brokurly.service.FAQService;
import com.brokurly.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class CSCenterController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    FAQService faqService;
    @RequestMapping("/notice")
    public String notice(Model m) throws Exception {

        List<NoticeListDto> noticeListDtoList = noticeService.getList();
        m.addAttribute("noticeListDtoList", noticeListDtoList);

        return "board/noticeList";
    }

    @RequestMapping("/detail")
    public String noticeboard(int bno, Model m) throws Exception {
        NoticeBoardDto noticeBoardDto = noticeService.getBoard(bno);
        m.addAttribute("noticeBoardDto", noticeBoardDto);

        return "board/noticeBoard";
    }

    @RequestMapping("/faq")
    public String faq(Model m) throws Exception {

        List<FAQListDto> FAQListDtoList = faqService.getFaqList();
        m.addAttribute("FAQListDtoList", FAQListDtoList);
        return "board/faqList";
    }

    @RequestMapping("/inquiry")
    public String inquiry() { return "board/inquiryList"; }
    @RequestMapping("/inquiryPost")
    public String inquiryPost() {
        return "board/inquiryPost";
    }

}
