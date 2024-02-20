package com.brokurly.dto.goods;


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
