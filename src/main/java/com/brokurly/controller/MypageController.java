package com.brokurly.controller;

import com.brokurly.dto.PointLogUsageDto;
import com.brokurly.service.PointLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageController {
    private final PointLogService pointLogService;

    @GetMapping("/point")
    String pointUsageLog(@RequestParam(defaultValue = "3") Integer period, Model model) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체

        log.info("최근 {}개월 기록을 조회", period);

        List<PointLogUsageDto> pointLogUsageList = pointLogService.findPointLogUsageByCustomer(custId, period);
        int pointLogUsageCount = pointLogService.getPointLogUsageByCustomerCount(custId, period);

        model.addAttribute("period", period);
        model.addAttribute("pointLogUsageList", pointLogUsageList);
        model.addAttribute("pointLogUsageCount", pointLogUsageCount);

        log.info("{}", pointLogUsageList);

        return "/mypage/point-usage-log";
    }
}
