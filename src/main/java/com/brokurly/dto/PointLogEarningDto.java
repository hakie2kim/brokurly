package com.brokurly.dto;

import lombok.*;

import java.util.Date;

@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor
public class PointLogEarningDto {
    private int pointNo;
    private String orderId;
    private int pointAmt;
    private Date procDt;
    private String pointSpec;
    private String pointStat;
    private Date expirDt;
}
