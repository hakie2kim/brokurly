package com.brokurly.entity.mypage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString @EqualsAndHashCode
public class PointLog {
    private int pointNo;
    private String orderId;
    private String custId;
    private int pointAmt;
    private Date procDt;
    private String pointSpec;
    private String pointStat;
}
