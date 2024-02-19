package com.brokurly.service.member;


import com.brokurly.dto.member.MemberAndSignupDto;
import org.springframework.validation.Errors;

import java.util.Map;

public interface MemberService {

    Map<String, String> validateHandling(Errors errors);
    void kakaoJoin(MemberAndSignupDto memberAndSignupDto);
    int signUp(MemberAndSignupDto memberAndSignupDto);
    MemberAndSignupDto kakaoLogin(String snsId);
    int getCountAll();
    int getCount(String custId);
    int getCountEmail(String email);
    int removeAll();
}