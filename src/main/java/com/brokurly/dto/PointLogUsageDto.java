package com.brokurly.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PointLogUsageDto {
    private String orderId;
    private int pointAmt;
    private Date procDt;
    private String pointSpec;
    private String pointStat;
}
