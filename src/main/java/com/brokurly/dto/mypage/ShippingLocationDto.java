package com.brokurly.dto.mypage;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class ShippingLocationDto {
    private String shipLocaId;
    private String addr;
    private String specAddr;
    private String defAddrFl;
    private String shipLocaRegDt;
    private String telNo;
    private String recAddr;
    private String recName;
    private String delFl;
    private String currAddrFl;

}
