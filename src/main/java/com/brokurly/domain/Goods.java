package com.brokurly.domain;

import com.brokurly.dto.GoodsDto;
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
    private String itemDcAmt;
    private String origin;
    private String pointFl;
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


    public GoodsDto makeDto(){
        return GoodsDto.builder()
                .itemId(itemId)
                .name(name)
                .exp(exp)
                .price(price)
                .dcRt(dcRt)
                .itemDcAmt(itemDcAmt)
                .origin(origin)
                .pointFl(pointFl)
                .shipType(shipType)
                .sellerName(sellerName)
                .pkgType(pkgType)
                .capa(capa)
                .sellUnit(sellUnit)
                .regDt(regDt)
                .adultVerifFl(adultVerifFl)
                .cateCode(cateCode)
                .itemQty(itemQty)
                .wishCnt(wishCnt)
                .bsnsNo(bsnsNo)
                .itemSpec(itemSpec)
                .sellCnt(sellCnt)
                .revCnt(revCnt)
                .stdySellerFl(stdySellerFl).build();
    }

    public void insert (GoodsDto goodsDto) {
        this.itemId = goodsDto.getItemId();
        this.name = goodsDto.getName();
        this.exp = goodsDto.getExp();
        this.price = goodsDto.getPrice();
        this.dcRt = goodsDto.getDcRt();
        this.itemDcAmt = goodsDto.getItemDcAmt();
        this.origin = goodsDto.getOrigin();
        this.pointFl = goodsDto.getPointFl();
        this.shipType = goodsDto.getShipType();
        this.sellerName = goodsDto.getSellerName();
        this.pkgType = goodsDto.getPkgType();
        this.capa = goodsDto.getCapa();
        this.sellUnit = goodsDto.getSellUnit();
        this.regDt = goodsDto.getRegDt();
        this.adultVerifFl = goodsDto.getAdultVerifFl();
        this.cateCode = goodsDto.getCateCode();
        this.itemQty = goodsDto.getItemQty();
        this.wishCnt = goodsDto.getWishCnt();
        this.bsnsNo = goodsDto.getBsnsNo();
        this.itemSpec = goodsDto.getItemSpec();
        this.sellCnt = goodsDto.getSellCnt();
        this.revCnt = goodsDto.getRevCnt();
        this.stdySellerFl = goodsDto.getStdySellerFl();


    }
}


