package com.brokurly.service;


import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;



@Service
public class SmsRestService {
     DefaultMessageService messageService;
    public void certifiedPhoneNumber(String telNo, String smsNum){
        String api_key = "";
        String api_secret = "";
        messageService =  NurigoApp.INSTANCE.initialize(api_key, api_secret, "https://api.coolsms.co.kr");

        Message message = new Message();
        message.setFrom(telNo);
        message.setTo(telNo);
        message.setText("["+smsNum+"] 브로컬리 인증번호를 입력해주세요.");

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);

    }
}
