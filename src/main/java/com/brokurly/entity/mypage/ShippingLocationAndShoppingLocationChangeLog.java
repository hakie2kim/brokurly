package com.brokurly.entity.mypage;

import com.brokurly.dto.mypage.ShippingLocationAddDto;
import com.brokurly.dto.mypage.ShippingLocationDto;
import com.brokurly.dto.mypage.ShippingLocationManagementDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ShippingLocationAndShoppingLocationChangeLog {
    // ShoppingLocation
    private String shipLocaId;
    private String addr;
    private String specAddr;
    private String defAddrFl;
    private String shipLocaRegDt;
    private String telNo;
    private String recAddr;
    private String recName;
    private String delFl;

    // ShoppingLocationChangeLog
    private int shipChgNo;
    private String name;
    private String chgStatus;
    private Date chgDt = java.sql.Timestamp.valueOf(LocalDateTime.now());
    private String custId;

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
}
