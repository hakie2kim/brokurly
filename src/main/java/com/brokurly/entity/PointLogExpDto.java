package com.brokurly.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString @EqualsAndHashCode
public class PointLogExpDto {
    private int pointAmt;
    private Date procDt;
    private String pointSpec;
    private String pointStat;
}
