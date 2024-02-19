package com.brokurly.controller;

import com.brokurly.service.SmsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Controller
@RequestMapping("/sms")
public class SmsRestController {

    @Autowired
    SmsRestService smsRestService;

    @PostMapping("/telNoCheck")
    @ResponseBody
    public String sendSMSSignup(@RequestParam(value="telNo") String telNo){

        String smsNum = "";
        for(int i=0; i < 6; i++) {
            int r = (int) (Math.random() * 8) + 1; // 보낼 인증번호 랜덤생성
            smsNum += Integer.toString(r);
        }
//        final String[] smsNum = {""};
//
//        IntStream intStream = new Random().ints(1,10);
//        intStream.distinct().limit(5).
//                forEach(i -> smsNum[0] += Integer.toString(i));


        smsRestService.certifiedPhoneNumber(telNo, smsNum);

        return smsNum;
    }
}
