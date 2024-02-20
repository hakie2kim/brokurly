package com.brokurly.controller.mypage;

import com.brokurly.dto.mypage.PointAndPointLogEarningDto;
import com.brokurly.dto.mypage.PointLogEarningDto;
import com.brokurly.dto.mypage.PointLogExpDto;
import com.brokurly.dto.mypage.PointLogUsageDto;
import com.brokurly.service.mypage.PointLogService;
import com.brokurly.service.mypage.PointService;
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
@RequestMapping("/mypage/point")
public class MypageController {
    private final PointLogService pointLogService;
    private final PointService pointService;

    @GetMapping("/usage")
    String pointUsageLog(@RequestParam(defaultValue = "3") Integer period, Model model) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체

        List<PointLogUsageDto> pointLogUsageList = pointLogService.findPointLogUsageByCustomerAndPeriod(custId, period);
        int pointLogUsageCount = pointLogService.getPointLogUsageCountByCustomerAndPeriod(custId, period);
        int totalAvailPoints = pointService.getTotalAvailPoints(custId);
        int totalAccumulPoints = pointLogService.getTotalAccumulPoints(custId);
        int totalPointsToBeExpired = pointService.getTotalPointsToBeExpired(custId);

        model.addAttribute("type", "사용");
        model.addAttribute("period", period);
        model.addAttribute("pointLogUsageList", pointLogUsageList);
        model.addAttribute("pointLogUsageCount", pointLogUsageCount);
        model.addAttribute("totalAvailPoints", totalAvailPoints);
        model.addAttribute("totalAccumulPoints", totalAccumulPoints);
        model.addAttribute("totalPointsToBeExpired", totalPointsToBeExpired);

        log.info("{}", pointLogUsageList);

        return "/mypage/point-usage-log";
    }

    @GetMapping("/exp")
    String pointExpLog(@RequestParam(defaultValue = "3") Integer period, Model model) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체

        List<PointLogExpDto> pointLogExpList = pointLogService.findPointLogExpByCustomerAndPeriod(custId, period);
        int pointLogExpCount = pointLogService.getPointLogExpCountByCustomerAndPeriod(custId, period);
        int totalAvailPoints = pointService.getTotalAvailPoints(custId);
        int totalAccumulPoints = pointLogService.getTotalAccumulPoints(custId);
        int totalPointsToBeExpired = pointService.getTotalPointsToBeExpired(custId);

        model.addAttribute("type", "소멸");
        model.addAttribute("period", period);
        model.addAttribute("pointLogExpList", pointLogExpList);
        model.addAttribute("pointLogExpCount", pointLogExpCount);
        model.addAttribute("totalAvailPoints", totalAvailPoints);
        model.addAttribute("totalAccumulPoints", totalAccumulPoints);
        model.addAttribute("totalPointsToBeExpired", totalPointsToBeExpired);

        log.info("{}", pointLogExpCount);

        return "/mypage/point-exp-log";
    }

    @GetMapping("/earning")
    String pointEarningLog(@RequestParam(defaultValue = "3") Integer period, Model model) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체

        List<PointAndPointLogEarningDto> pointLogEarningList = pointLogService.findPointLogEarningByCustomerAndPeriod(custId, period);
        int pointLogEarningCount = pointLogService.getPointLogEarningCountByCustomerAndPeriod(custId, period);
        int totalAvailPoints = pointService.getTotalAvailPoints(custId);
        int totalAccumulPoints = pointLogService.getTotalAccumulPoints(custId);
        int totalPointsToBeExpired = pointService.getTotalPointsToBeExpired(custId);

        model.addAttribute("type", "적립");
        model.addAttribute("period", period);
        model.addAttribute("pointLogEarningList", pointLogEarningList);
        model.addAttribute("pointLogEarningCount", pointLogEarningCount);
        model.addAttribute("totalAvailPoints", totalAvailPoints);
        model.addAttribute("totalAccumulPoints", totalAccumulPoints);
        model.addAttribute("totalPointsToBeExpired", totalPointsToBeExpired);

        return "/mypage/point-earning-log";
    }
}
