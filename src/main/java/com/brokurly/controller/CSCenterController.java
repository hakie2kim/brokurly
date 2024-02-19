package com.brokurly.controller;

import com.brokurly.dto.NoticeBoardDto;
import com.brokurly.dto.NoticeListDto;
import com.brokurly.dto.FAQListDto;
import com.brokurly.service.FAQService;
import com.brokurly.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class CSCenterController {
    private final NoticeService noticeService;
    private final FAQService faqService;
    @GetMapping("/notice")
    public String notice(Model model) throws Exception {
        List<NoticeListDto> noticeListDtoList = noticeService.getList();
        model.addAttribute("noticeListDtoList", noticeListDtoList);
        return "board/noticeList";
    }

    @RequestMapping("/detail")
    public String noticeboard(int bno, Model model) throws Exception {
        NoticeBoardDto noticeBoardDto = noticeService.getBoard(bno);
        model.addAttribute("noticeBoardDto", noticeBoardDto);
        return "board/noticeBoard";
    }

    @RequestMapping("/faqboard")
    public String faq(Model model) throws Exception {
        List<FAQListDto> FAQListDtoList = faqService.getFaqList();
        model.addAttribute("FAQListDtoList", FAQListDtoList);
        return "board/faqList";
    }

    @RequestMapping("/inquiry")
    public String inquiry() { return "board/inquiryList"; }


    @RequestMapping("/inquiryPost")
    public String inquiryPost() {
        return "board/inquiryPost";
    }
}