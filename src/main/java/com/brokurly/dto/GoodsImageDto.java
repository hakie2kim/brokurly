package com.brokurly.dto;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class GoodsImageDto {
    private String img;
    private String repImgFl;
    private String itemId;

}
