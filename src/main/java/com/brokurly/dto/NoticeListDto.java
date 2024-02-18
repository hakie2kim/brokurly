package com.brokurly.dto;

import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeListDto {
    private int bno;
    private String title;
    private String adminId;
    private String regDt;
}
