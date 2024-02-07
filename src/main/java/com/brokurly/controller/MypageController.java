package com.brokurly.controller;

import com.brokurly.entity.PointLogUsageDto;
import com.brokurly.service.PointLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageController {
    private final PointLogService pointLogService;

    @GetMapping("/point")
    String pointUsageLog(Model model) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체

        List<PointLogUsageDto> pointLogUsageList = pointLogService.findPointLogByCustId(custId);
        model.addAttribute("pointLogUsageList", pointLogUsageList);

        return "point-usage-log";
    }
}
