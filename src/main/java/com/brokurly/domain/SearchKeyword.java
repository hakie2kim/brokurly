package com.brokurly.domain;


import lombok.*;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SearchKeyword {
    private String keyword;
    private String itemIdList;

}
