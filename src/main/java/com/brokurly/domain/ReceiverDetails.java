package com.brokurly.domain;

import com.brokurly.dto.ReceiverDetailsChangeDto;
import com.brokurly.dto.ReceiverDetailsDto;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ReceiverDetails {
    private String rcvDtlId;
    private String shipLocaId;
    private String custId;
    private String rcvName;
    private String telNo;
    private String rcvPlace;
    private String enterMthd;
    private String placeExp;
    private String msgTime;

    public ReceiverDetailsDto makeFullDto() {
        return ReceiverDetailsDto.builder()
                .rcvDtlId(rcvDtlId)
                .shipLocaId(shipLocaId)
                .custId(custId)
                .rcvName(rcvName)
                .telNo(telNo)
                .rcvPlace(rcvPlace)
                .enterMthd(enterMthd)
                .placeExp(placeExp)
                .msgTime(msgTime)
                .build();
    }

    public void changeReceiverDetails(ReceiverDetailsChangeDto changeDto) {
        this.rcvName = changeDto.getRcvName();
        this.telNo = changeDto.getTelNo();
        this.rcvPlace = changeDto.getRcvPlace();
        this.enterMthd = changeDto.getEnterMthd();
        this.placeExp = changeDto.getPlaceExp();
        this.msgTime = changeDto.getMsgTime();
    }
}
