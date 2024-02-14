package com.brokurly.domain;

import com.brokurly.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Cart {   //1. insert(넣을 값)할  값을 담을 Dto를 만듦
  private String itemId;
  private String custId;
  private int itemCnt;


  public CartDto makeDto() {  //getter
    return CartDto.builder()
        .custId(custId)
        .itemId(itemId)
        .itemCnt(itemCnt)
        .build();
  }
  public void changeStatus(CartDto cartDto){  //setter
    this.custId = cartDto.getCustId();
    this.itemId = cartDto.getItemId();
    this.itemCnt = cartDto.getItemCnt();
  }
}
