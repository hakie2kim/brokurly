package com.brokurly.service.member;


import com.brokurly.dto.member.MemberAndLoginDto;
import com.brokurly.dto.member.MemberAndSignupDto;
import org.springframework.validation.Errors;

import java.util.Map;

public interface MemberService {

    Map<String, String> validateHandling(Errors errors);

    // mypage/info/modify
    MemberAndSignupDto readMemberByOne(String custId);
    MemberAndLoginDto localLogin(MemberAndLoginDto memberAndLoginDto);
    MemberAndSignupDto signUpBySns(String snsId);
    void kakaoJoin(MemberAndSignupDto memberAndSignupDto);
    int signUp(MemberAndSignupDto memberAndSignupDto);
    int kakaoLogin(String snsId);
    String findBySnsId(String snsId);
    int getCountAll();
    int getCount(String custId);
    int getCountEmail(String email);
    int removeAll();
}