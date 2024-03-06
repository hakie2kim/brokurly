package com.brokurly.controller.mypage;


import com.brokurly.dto.mypage.PointAndPointLogEarningDto;
import com.brokurly.dto.mypage.PointLogExpDto;
import com.brokurly.dto.mypage.PointLogUsageDto;

import com.brokurly.dto.mypage.*;

import com.brokurly.service.mypage.PointLogService;
import com.brokurly.service.mypage.PointService;
import com.brokurly.service.mypage.ShippingLocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageController {
    private final PointLogService pointLogService;
    private final PointService pointService;
    private final ShippingLocationService shippingLocationService;

    @GetMapping("/point/usage")
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

    @GetMapping("/point/exp")
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

    @GetMapping("/point/earning")
    String pointEarningLog(@RequestParam(defaultValue = "3") Integer period, Model model) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체

        List<PointAndPointLogEarningDto> pointLogEarningList = pointLogService.findPointLogEarningByCustomerAndPeriod(custId, period);

//        for (PointLogEarningDto pointLogEarningDto : pointLogEarningList_) {
//            String orderId = pointLogUsageDto.getOrderId();
//            int pointAmt = pointLogUsageDto.getPointAmt();
//            Date procDt = pointLogUsageDto.getProcDt();
//            String pointSpec = pointLogUsageDto.getPointSpec();
//
//            /*String pointSpecDetails = "";
//            if (orderId == null) {
//                pointSpecDetails = new SimpleDateFormat("MM/dd까지 사용가능").format(pointLogUsageDto.getProcDt());
//            } else {
//                pointSpecDetails = String.format("주문번호 (%s)", orderId);
//            }*/
//
//            String pointStat = pointLogUsageDto.getPointStat();
//            Date expDt = pointService.findPointByPointId(pointLogUsageDto.get)
//
//            pointLogEarningList.add(new PointLogEarningDto(pointNo, orderId, pointAmt, procDt, pointSpec, pointStat, expDt));
//        }


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

    @GetMapping("/address")
    String manageAddress(Model model) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체
        List<ShippingLocationDto> shippingLocationList = shippingLocationService.getShippingLocationListByCustomer(custId);
        model.addAttribute("shippingLocationList", shippingLocationList);
        return "/mypage/address";
    }

    @PostMapping("/address")
    @ResponseBody
    HttpStatus addShippingAddress(@RequestBody ShippingLocationAddFormDto shippingLocationAddFormDto) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체

        String addr = shippingLocationAddFormDto.getAddr();
        String specAddr = shippingLocationAddFormDto.getSpecAddr();
        String defAddrFl = Boolean.parseBoolean(shippingLocationAddFormDto.getDefAddrFl()) ? "Y" : "N";
        log.info("@PostMapping(\"/address\") addShippingAddress addr: {} specAddr: {} defAddrFl: {}", addr, specAddr, defAddrFl);

        // 기본 배송지로 설정할 경우, 나머지 기본 배송지 설정을 해제
        if (defAddrFl.equals("Y"))
            shippingLocationService.unflagDefAddr(custId);

        shippingLocationService.addNewShippingLocation(custId, addr, specAddr, defAddrFl);
//        List<ShippingLocationDto> shippingLocationListByCustomer = shippingLocationService.getShippingLocationListByCustomer(custId);

//        return new ResponseEntity<>("배송지 추가", HttpStatus.OK);
        return HttpStatus.OK;
    }

    @GetMapping("/address/shipping-address/update/{shipLocaId}")
    String modifyShippingLocation(@PathVariable String shipLocaId, Model model) {
        ShippingLocationModifyPageDto shippingLocationModifyPageDto = shippingLocationService.getShippingLocationToModifyByShipLocaId(shipLocaId);
        model.addAttribute("shippingLocationModifyPageDto", shippingLocationModifyPageDto);
        return "/mypage/address-update";
    }

    @PatchMapping("/address/shipping-address/update/{shipLocaId}")
    @ResponseBody
//    ResponseEntity<String> modifyShippingAddress(@ModelAttribute ShippingLocationUpdateDto shippingLocationUpdateDto) {
    HttpStatus modifyShippingLocation(@PathVariable String shipLocaId, @ModelAttribute ShippingLocationModifyDto shippingLocationModifyDto) {
        String custId = "hakie2kim"; // 로그인 기능 구현 후 세션에서 갖고 오는 것으로 대체

        shippingLocationModifyDto.setShipLocaId(shipLocaId);
        String specAddr = shippingLocationModifyDto.getSpecAddr();

        String defAddrFl = shippingLocationModifyDto.getDefAddrFl().equals("on") ? "Y" : "N";
        shippingLocationModifyDto.setDefAddrFl(defAddrFl);

        String telNo = shippingLocationModifyDto.getTelNo().isEmpty() ? null : shippingLocationModifyDto.getTelNo();
        shippingLocationModifyDto.setTelNo(telNo);

        String recName = shippingLocationModifyDto.getRecName();

        /*// 현재 배송지 수정
        String currAddrFl = shippingLocationModifyDto.getCurrAddrFl().equals("on") ? "Y" : "N";
        if ("Y".equals(currAddrFl)) {
            shippingLocationService.modifyCurrShippingLocation(custId, shipLocaId);
            return HttpStatus.OK;
        }*/

        /*log.info("ship_loca_id: {} specAddr: {} defAddrFl: {} telNo: {} recName: {} currAddrFl: {}",
                shipLocaId, specAddr, defAddrFl, telNo, recName, currAddrFl
        );*/
        log.info("ship_loca_id: {} specAddr: {} defAddrFl: {} telNo: {} recName: {}",
                shipLocaId, specAddr, defAddrFl, telNo, recName
        );

        shippingLocationService.modifyShippingLocation(custId, shippingLocationModifyDto);

        return HttpStatus.OK;
    }

    @GetMapping("/address/shipping-address")
    String shippingAddress() {
        return "/mypage/shipping-address";
    }

    /*@GetMapping("/address/shipping-address/result/{fullAddr}")
    String addAddressResult(@PathVariable String fullAddr, Model model) {
        log.info("{}", fullAddr);
        model.addAttribute("fullAddr", fullAddr);
        return "/mypage/shipping-address-result";
    }*/

    @PostMapping("/address/shipping-address/result")
    String shippingAddressResult(String addr, Model model) {
        log.info("@PostMapping(\"/address/shipping-address/result\") shippingAddressResult addr: {}", addr);
        model.addAttribute("addr", addr);

        return "/mypage/shipping-address-result";

        /*if (specAddr == null) {
            return "/mypage/shipping-address-result";
        } else {
            log.info("{}", specAddr);
            model.addAttribute("specAddr", specAddr);
            return "redirect:/mypage/address";
        }*/
    }

}
