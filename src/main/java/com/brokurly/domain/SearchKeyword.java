package com.brokurly.domain;


import lombok.*;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SearchKeyword {
    private String keyword;
    private String itemIdList;
}
