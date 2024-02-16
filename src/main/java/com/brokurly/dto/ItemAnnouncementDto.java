package com.brokurly.dto;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class ItemAnnouncementDto {
    private String itemId;
    private String itemAnnCate;
    private String itemAnn;
}
