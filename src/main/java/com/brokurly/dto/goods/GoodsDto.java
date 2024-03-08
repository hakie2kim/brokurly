package com.brokurly.dto.goods;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class GoodsDto {
  private String itemId;
  @NotBlank(message = "이름은 필수 입력 값 입니다.")
  private String name;
  @NotBlank(message = "필수 입력 값 입니다.")
  private String exp;
  private int price;
  private int dcRt;
  private int itemDcAmt;
  private String origin;
  private String pointFl;
  private String cpnElgFl;
  private String shipType;
  private String sellerName;
  private String pkgType;
  private String capa;
  private int sellUnit;
  private String adultVerifFl;
  private String cateCode;
  private int itemQty;
  private String bsnsNo;
  private String itemSpec;
  private String stdySellerFl;
  //추가
//  private int salePrice;  //할인이 들어간 가격

}
