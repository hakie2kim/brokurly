package com.brokurly.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * packageName    : com.brokurly.utils
 * fileName       : MailTempKey
 * author         : Sora
 * date           : 2024-03-03
 * description    : 메일 인증번호 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-03        Sora       최초 생성
 */
@NoArgsConstructor
@AllArgsConstructor
public class MailTempKey {

    private String smsNum = "";

   public String getKey() {
        StringBuffer sb = new StringBuffer();

       for (int i = 0; i < 6; i++) {
           int r = (int) (Math.random() * 8) + 1; // 보낼 인증번호 랜덤생성
           sb.append(Integer.toString(r));
       }
       return sb.toString();
   }

}
