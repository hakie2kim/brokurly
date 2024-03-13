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
  @NotBlank(message = "필수 입력 값 입니다.")
  private String itemId;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String name;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String exp;

  @NotBlank(message = "필수 입력 값 입니다.")
  private int price;

  @NotBlank(message = "필수 입력 값 입니다.")
  private int dcRt;

  @NotBlank(message = "필수 입력 값 입니다.")
  private int itemDcAmt;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String origin;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String pointFl;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String cpnElgFl;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String shipType;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String sellerName;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String pkgType;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String capa;

  @NotBlank(message = "필수 입력 값 입니다.")
  private int sellUnit;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String adultVerifFl;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String cateCode;

  @NotBlank(message = "필수 입력 값 입니다.")
  private int itemQty;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String bsnsNo;

  @NotBlank(message = "필수 입력 값 입니다.")
  private String itemSpec;

}
