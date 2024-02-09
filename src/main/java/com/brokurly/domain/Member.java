package com.brokurly.domain;

import lombok.*;

import java.util.Date;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
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

}
