package com.brokurly.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MemberAndSignup {
    private String custId;
    private String pwd;
    private String name;
    private String email;
    private String telNo;
    private String sex = "M";
    private String birthDt;
    private Date regDt;
    private String adultVerifDt = "0";
    private int consent;    // 혜택정보 수신동의


    public MemberAndSignup(){}
    public MemberAndSignup(String custId, String pwd, String name, String email, String telNo, String sex, String birthDt, int consent) {
        this.custId = custId;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.telNo = telNo;
        this.sex = sex;
        this.birthDt = birthDt;
        this.consent = consent;
    }

}