package com.brokurly.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Cart {   //1. insert(넣을 값)할  값을 담을 Dto를 만듦
  private String itemId;
  private String custId;
  private int itemCnt;



}
