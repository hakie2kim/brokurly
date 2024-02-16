package com.brokurly.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class CartDto {
  private String itemId;
  private String custId;
  private int itemCnt;

//  public CartDto(String itemId, String custId, int itemCnt){
//    this.itemId = itemId;
//    this.custId = custId;
//    this.itemCnt = itemCnt;
//  }
}
