package com.brokurly.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Member {
    private String custId;
    private String pwd;
    private String name;
    private String email;
    private String telNo;
    private String sex = "M";
    private String birthDt;
    private Date regDt;
    private String adultVerifDt = "0";
    private int cartCnt;
    private int point;
    private int consent;    // 혜택정보 수신동의
    private String actStat;
    private String grade;

    public Member(){}
    public Member(String custId, String pwd, String name, String email, String telNo, String sex, String birthDt, int consent) {
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
