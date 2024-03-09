package com.brokurly.dto.categories;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class PriceFilterDto {

    String priceFilterNum;
    int price1;
    int price2;
    int price3;
}
