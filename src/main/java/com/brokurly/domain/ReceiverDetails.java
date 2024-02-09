package com.brokurly.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

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
    private String rcvAddr;
    private String enterMthd;
    private String doorPwd;
    private String guardCall;
    private String etc;
    private String msgTime;
}
