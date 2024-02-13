package com.brokurly.domain;

import lombok.*;

import java.sql.Timestamp;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Goods {
  private String itemId;
  private String name;
  private String exp;
  private int price;
  private double dcRt;
  private int itemDcAmt;
  private String origin;
  private String pointFl;
  private String cpnElgFl;
  private String shipType;
  private String sellerName;
  private String pkgType;
  private String capa;
  private int sellUnit;
  private Timestamp regDt;
  private String adultVerifFl;
  private String cateCode;
  private int itemQty;
  private int wishCnt;
  private String bsnsNo;
  private String itemSpec;
  private int sellCnt;
  private int revCnt;
  private String stdySellerFl;
}