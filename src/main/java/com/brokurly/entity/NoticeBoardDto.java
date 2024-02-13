package com.brokurly.entity;

import lombok.Data;

@Data
public class NoticeBoardDto {
    private String title;
    private String adminId;
    private String regDt;
    private String content;
}
