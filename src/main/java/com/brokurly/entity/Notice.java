package com.brokurly.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private int bno;
    private String adminId;
    private String title;
    private String content;
    private String pubFl;
    private String notiFl;
    private int hit;
    private String regDt;
}
