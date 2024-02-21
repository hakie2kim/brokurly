package com.brokurly.dto.cart;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class CartDto {
    private String itemId;
    private int itemCnt;  //카트에 담긴 상품 개수

    //상품테이블
    private String name;  //상품이름
    private int price;  //상품 가격
    private String shipType;  //샛별배송여부
    private String pkgType;   //포장타입
    private int disPrice; //상품 할인된 가격
}