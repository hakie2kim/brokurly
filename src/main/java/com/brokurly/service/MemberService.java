package com.brokurly.service;

import com.brokurly.domain.MemberAndSignup;

public interface MemberService {
    int signUp(MemberAndSignup memberAndSignup);
    int getCountAll();
    int getCount(String custId);
    int getCountEmail(String email);
    int removeAll();
}
