package com.brokurly.entity.goods;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class GoodsReivewBoard {
  private String revNo;
  private String itemId;
  private String custId;
  private String content;
  private Timestamp regDt;
  private int likeCnt;

}
