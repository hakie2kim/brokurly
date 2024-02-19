package com.brokurly.service.member;

import com.brokurly.entity.member.MemberAndSignup;

public interface MemberService {
    int signUp(MemberAndSignup memberAndSignup);
    int getCountAll();
    int getCount(String custId);
    int getCountEmail(String email);
    int removeAll();
}
