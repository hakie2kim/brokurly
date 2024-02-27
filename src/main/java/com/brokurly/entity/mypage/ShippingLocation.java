package com.brokurly.entity.mypage;

import com.brokurly.dto.mypage.ShippingLocationAddDto;
import com.brokurly.dto.mypage.ShippingLocationDto;
import com.brokurly.dto.mypage.ShippingLocationManagementDto;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ShippingLocation {
    private String shipLocaId;
    private String addr;
    private String specAddr;
    private String defAddrFl;
    private String shipLocaRegDt;
    private String telNo;
    private String recAddr;
    private String recName;
    private String delFl;

    public ShippingLocationDto makeShippingLocationDto() {
        return ShippingLocationDto.builder()
                .shipLocaId(shipLocaId)
                .addr(addr)
                .specAddr(specAddr)
                .defAddrFl(defAddrFl)
                .shipLocaRegDt(shipLocaRegDt)
                .telNo(telNo)
                .recAddr(recAddr)
                .recName(recName)
                .delFl(delFl)
                .build();
    }

    public void updateShippingLocationDto(ShippingLocationDto shippingLocationDto) {
       this.shipLocaId = shippingLocationDto.getShipLocaId();
       this.addr = shippingLocationDto.getAddr();
       this.specAddr = shippingLocationDto.getSpecAddr();
       this.defAddrFl = shippingLocationDto.getDefAddrFl();
       this.shipLocaRegDt = shippingLocationDto.getShipLocaRegDt();
       this.telNo = shippingLocationDto.getTelNo();
       this.recAddr = shippingLocationDto.getRecAddr();
       this.recName = shippingLocationDto.getRecName();
       this.delFl = shippingLocationDto.getDelFl();
    }

    public ShippingLocationManagementDto makeShippingLocationManagementDto() {
        return ShippingLocationManagementDto.builder()
                .shipLocaId(shipLocaId)
                .addr(addr)
                .specAddr(specAddr)
                .defAddrFl(defAddrFl)
                .shipLocaRegDt(shipLocaRegDt)
                .telNo(telNo)
                .recName(recName)
                .delFl(delFl)
                .build();
    }

    public void updateShippingLocationManagementDto(ShippingLocationManagementDto shippingLocationManagementDto) {
        this.shipLocaId = shippingLocationManagementDto.getShipLocaId();
        this.addr = shippingLocationManagementDto.getAddr();
        this.specAddr = shippingLocationManagementDto.getSpecAddr();
        this.defAddrFl = shippingLocationManagementDto.getDefAddrFl();
        this.shipLocaRegDt = shippingLocationManagementDto.getShipLocaRegDt();
        this.telNo = shippingLocationManagementDto.getTelNo();
        this.recName = shippingLocationManagementDto.getRecName();
        this.delFl = shippingLocationManagementDto.getDelFl();
    }

    public ShippingLocationAddDto makeShippingLocationAddDto() {
        return ShippingLocationAddDto.builder()
                .shipLocaId(shipLocaId)
                .addr(addr)
                .specAddr(specAddr)
                .defAddrFl(defAddrFl)
                .shipLocaRegDt(shipLocaRegDt)
                .delFl(delFl)
                .build();
    }

    public void updateShippingLocationAddDto(ShippingLocationAddDto shippingLocationAddDto) {
        this.shipLocaId = shippingLocationAddDto.getShipLocaId();
        this.addr = shippingLocationAddDto.getAddr();
        this.specAddr = shippingLocationAddDto.getSpecAddr();
        this.defAddrFl = shippingLocationAddDto.getDefAddrFl();
        this.shipLocaRegDt = shippingLocationAddDto.getShipLocaRegDt();
        this.delFl = shippingLocationAddDto.getDelFl();
    }
}
