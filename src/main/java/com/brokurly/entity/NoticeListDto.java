package com.brokurly.entity;

import lombok.*;

import java.util.Date;

@Data
public class NoticeListDto {
    private int bno;
    private String title;
    private String adminId;
    private String regDt;
}
