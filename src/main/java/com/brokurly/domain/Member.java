package com.brokurly.domain;

import com.brokurly.dto.MemberAndSignupDto;
import com.brokurly.dto.OauthDto;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String custId;
    private String pwd;
    private String name;
    private String email;
    private String telNo;
    private String sex;
    private String birthDt;
    private Date regDt;
    private String adultVerifDt;
    private int cartCnt;
    private int point;
    private String consent;
    private String actStat;
    private String grade;

    private String snsId;


    public MemberAndSignupDto makeFullDto(){
        return MemberAndSignupDto.builder()
                .custId(custId)
                .pwd(pwd)
                .name(name)
                .email(email)
                .telNo(telNo)
                .sex(sex)
                .birthDt(birthDt)
                .consent(consent)
                .snsId(snsId)
                .build();
    }


    public void changeStatus(MemberAndSignupDto memberAndSignupDto) {
        this.custId = memberAndSignupDto.getCustId();
        this.pwd = memberAndSignupDto.getPwd();
        this.name = memberAndSignupDto.getName();
        this.email = memberAndSignupDto.getEmail();
        this.telNo = memberAndSignupDto.getTelNo();
        this.sex = memberAndSignupDto.getSex();
        this.birthDt = memberAndSignupDto.getBirthDt();
        this.consent = memberAndSignupDto.getConsent();
        this.snsId = memberAndSignupDto.getSnsId();
    }



}

