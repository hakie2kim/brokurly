package com.brokurly.entity.mypage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString @EqualsAndHashCode
public class Point {
    private int pointNo;
    private String custId;
    private int pointAmt;
    private Date expirDt;
}
