package com.brokurly.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class GoodsInquiryLogDto {
  private String custId;
  private String itemId;
  private String inqTitle;
  private String inqContent;
  private String regDt;
  private String privFl;
  private String replyStat;
  private String replyContent;
  private String replyDt;
  private int inqNo;
}
