package com.brokurly.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ItemAnnouncement {
    private String itemId;
    private String itemAnnCate;
    private String itemAnn;
}
