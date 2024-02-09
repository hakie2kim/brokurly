package com.brokurly.service;

import com.brokurly.dto.MemberAndSignup;

public interface MemberService {
    int signUp(MemberAndSignup memberAndSignup);
    int getCountAll();
    int getCount(String custId);
    int removeAll();
}
