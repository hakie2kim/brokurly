package com.brokurly.controller;

import com.brokurly.service.SmsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.IntStream;

@RestController
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

        // 보낼 인증번호 랜덤 생성
//        IntStream intStream = new Random().ints(1,10);
//        intStream.limit(6)
//                 .forEach((i)-> Integer.toString(i));


        smsRestService.certifiedPhoneNumber(telNo, smsNum);

        return smsNum;
    }
}
