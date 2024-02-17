package com.brokurly.domain;

import com.brokurly.dto.CartDto;
import com.brokurly.dto.GoodsDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Cart {   //1. insert(넣을 값)할  값을 담을 Dto를 만듦
  private String itemId;
  private String custId;
  private int itemCnt;

  public CartDto makeFullDto(GoodsDto goodsDto){   //setter
    return CartDto.builder()
        .custId(custId)
        .itemId(itemId)
        .itemCnt(itemCnt)


        .disPrice(goodsDto.getPrice() - goodsDto.getItemDcAmt()) //할인된 금액
        .name(goodsDto.getName()) //상품이름
//        .itemId(goodsDto.getItemId()) //상품아이디
        .price(goodsDto.getPrice()) //상품 원가

        .shipType(goodsDto.getShipType()) //배송타입(새벽배송)
        .pkgType(goodsDto.getPkgType()) //포장타입(냉장,냉동)



        .build();
  }

//  public void changeStatus (GoodsDto goodsDto){ //getter
//    this.custId = goodsDto.getCustId();
//    this.itemId = goodsDto.getItemId();
//    this.itemCnt = cartDto.getItemCnt();
//  }


}
