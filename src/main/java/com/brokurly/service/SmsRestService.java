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
        System.out.println("test22222222222 = " + "test22222222222 ");
//        Message coolsms = new Message("NCS61ZCTBB4XMBJ3", "YVOY1D63MCVEXP6RVFPFTYPROK9YBMFJ");
        Message message = new Message();
//        System.out.println("coolsms = " + coolsms);
        System.out.println("test111111111111 = " + "test111111111111");
        message.setFrom(telNo);
        message.setTo(telNo);
        message.setText("[Web발신] </br> ["+smsNum+"] 브로컬리 인증번호를</br>입력해주세요.");
//        HashMap<String, String> params = new HashMap<String,String>();
//        params.put("to",telNo);
//        params.put("from", telNo);
//        params.put("type","SMS");
//        params.put("text", "[Web발신] </br> ["+smsNum+"] 브로컬리 인증번호를</br>입력해주세요.");
//        params.put("app_version", "test app 1.2");
//        System.out.println("params = " + params);
        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);
//        try{
//            JSONObject obj = coolsms.sendPostRequest("https://api.coolsms.co.kr",params);
//            System.out.println("obj = " + obj.toString());
//        }catch (CoolsmsException e){
//            System.out.println("e.getCode() = " + e.getCode());
//            System.out.println("e.getCode() = " + e.getCode());
//        }

    }
}
