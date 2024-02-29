package com.brokurly.entity.goods;

import com.brokurly.dto.goods.GoodsByBsnsNoDto;
import com.brokurly.dto.goods.GoodsDto;
import com.brokurly.dto.goods.GoodsForCartDto;
import com.brokurly.dto.goods.GoodsListDto;
import lombok.*;
import java.util.Date;

@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
  private String itemId;
  private String name;
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
  private Date regDt;
  private String adultVerifFl;
  private String cateCode;
  private int itemQty;
  private int wishCnt;
  private String bsnsNo;
  private String itemSpec;
  private int sellCnt;
  private int revCnt;

  //추가
  private int salePrice;  //할인이 들어간 가격

  public void initSaleTotal(){
    salePrice = price - itemDcAmt;
    if (salePrice < 0)
      throw new RuntimeException("할인된 가격은 0원 이하일 수 없습니다.");
  }
  public GoodsListDto makeGoodsList(){
    return GoodsListDto.builder()
            .itemId(itemId)
            .name(name)
            .exp(exp)
            .price(price)
            .dcRt(dcRt)
            .disPrice(price-itemDcAmt)
            .itemDcAmt(itemDcAmt)
            .revCnt(revCnt)
            .shipType(shipType)
            .build();
  }

  public GoodsDto makeFullDto() {
    return GoodsDto.builder()
            .itemId(itemId)
            .name(name)
            .exp(exp)
            .price(price)
            .dcRt(dcRt)
            .itemDcAmt(itemDcAmt)
            .origin(origin)
            .pointFl(pointFl)
            .cpnElgFl(cpnElgFl)
            .shipType(shipType)
            .sellerName(sellerName)
            .pkgType(pkgType)
            .capa(capa)
            .sellUnit(sellUnit)
            .adultVerifFl(adultVerifFl)
            .cateCode(cateCode)
            .itemQty(itemQty)
            .bsnsNo(bsnsNo)
            .itemSpec(itemSpec)
            .salePrice(salePrice)
            .build();
  }

  public GoodsForCartDto toGoodsForCartDto() {
    return GoodsForCartDto.builder()
            .name(name)
            .price(price)
            .itemDcAmt(itemDcAmt)
            .shipType(shipType)
            .pkgType(pkgType)
            .build();
  }

  public GoodsByBsnsNoDto toGoodsByBsnsNoDto(String bsnsNo){
    return GoodsByBsnsNoDto.builder()
            .itemId(itemId)
            .name(name)
            .price(price)
            .dcRt(dcRt)
            .itemDcAmt(itemDcAmt)
            .bsnsNo(this.bsnsNo)
            .build();
  }

  public void changeStatus(GoodsDto goodsDto) {
    this.itemId = goodsDto.getItemId();
    this.name = goodsDto.getName();
    this.exp = goodsDto.getExp();
    this.price = goodsDto.getPrice();
    this.dcRt = goodsDto.getDcRt();
    this.itemDcAmt = goodsDto.getItemDcAmt();
    this.origin = goodsDto.getOrigin();
    this.pointFl = goodsDto.getPointFl();
    this.cpnElgFl = goodsDto.getCpnElgFl();
    this.shipType = goodsDto.getShipType();
    this.sellerName = goodsDto.getSellerName();
    this.pkgType = goodsDto.getPkgType();
    this.capa = goodsDto.getCapa();
    this.sellUnit = goodsDto.getSellUnit();
    this.adultVerifFl = goodsDto.getAdultVerifFl();
    this.cateCode = goodsDto.getCateCode();
    this.itemQty = goodsDto.getItemQty();
    this.bsnsNo = goodsDto.getBsnsNo();
    this.itemSpec = goodsDto.getItemSpec();
    this.salePrice = goodsDto.getSalePrice();
  }
}
