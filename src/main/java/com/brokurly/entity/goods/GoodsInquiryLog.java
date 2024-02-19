package com.brokurly.entity.goods;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class GoodsInquiryLog {
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
