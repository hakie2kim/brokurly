package com.brokurly.dto;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class SearchKeywordDto {
    private String keyword;
    private String itemIdList;
}
