package com.brokurly.domain;

import com.brokurly.dto.PointLogEarningDto;
import com.brokurly.dto.PointLogExpDto;
import com.brokurly.dto.PointLogUsageDto;
import lombok.*;

import java.util.Date;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PointLog {
    private int pointNo;
    private String orderId;
    private String custId;
    private int pointAmt;
    private Date procDt;
    private String pointSpec;
    private String pointStat;

    public PointLog(String orderId, String custId, int pointAmt, Date procDt, String pointSpec, String pointStat) {
        this.orderId = orderId;
        this.custId = custId;
        this.pointAmt = pointAmt;
        this.procDt = procDt;
        this.pointSpec = pointSpec;
        this.pointStat = pointStat;
    }

    public PointLog(String custId, int pointAmt, Date procDt, String pointSpec, String pointStat) {
        this.custId = custId;
        this.pointAmt = pointAmt;
        this.procDt = procDt;
        this.pointSpec = pointSpec;
        this.pointStat = pointStat;
    }

    public PointLogUsageDto getPointLogUsageDto() {
        return PointLogUsageDto.builder()
                .orderId(orderId)
                .pointAmt(pointAmt)
                .procDt(procDt)
                .pointSpec(pointSpec)
                .pointStat(pointStat)
                .build();
    }

    /*public void setPointLogUsageDto(PointLogUsageDto pointLogUsageDto) {
        this.orderId = pointLogUsageDto.getOrderId();
        this.pointAmt = pointLogUsageDto.getPointAmt();
        this.procDt = pointLogUsageDto.getProcDt();
        this.pointSpec = pointLogUsageDto.getPointSpec();
        this.pointStat = pointLogUsageDto.getPointStat();
    }*/

    public PointLogEarningDto getPointLogEarningDto() {
        return PointLogEarningDto.builder()
                .pointAmt(pointAmt)
                .pointStat(pointStat)
                .build();
    }

    public PointLogExpDto getPointLogExpDto() {
        return PointLogExpDto.builder()
                .pointAmt(pointAmt)
                .procDt(procDt)
                .pointSpec(pointSpec)
                .pointStat(pointStat)
                .build();
    }

    /*public void setPointLogExpDto(PointLogExpDto pointLogExpDto) {
        this.pointAmt = pointLogExpDto.getPointAmt();
        this.procDt = pointLogExpDto.getProcDt();
        this.pointSpec = pointLogExpDto.getPointSpec();
        this.pointStat = pointLogExpDto.getPointStat();
    }*/
}
