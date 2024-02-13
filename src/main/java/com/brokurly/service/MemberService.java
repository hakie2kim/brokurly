package com.brokurly.service;

import com.brokurly.entity.MemberAndSignup;

public interface MemberService {
    int signUp(MemberAndSignup memberAndSignup);
    int getCountAll();
    int getCount(String custId);
    int getCountEmail(String email);
    int removeAll();
}
