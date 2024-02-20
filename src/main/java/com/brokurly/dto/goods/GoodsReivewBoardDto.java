package com.brokurly.dto.goods;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class GoodsReivewBoardDto {
  private String revNo;
  private String itemId;
  private String custId;
  private String content;
  private Timestamp regDt;
  private int likeCnt;
}
