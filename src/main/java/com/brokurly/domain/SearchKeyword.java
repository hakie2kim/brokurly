package com.brokurly.domain;


import com.brokurly.dto.SearchKeywordDto;
import lombok.*;


@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SearchKeyword {
    private String keyword;
    private String itemIdList;

    public SearchKeywordDto makeFullDto(){
        return SearchKeywordDto.builder()
                .keyword(keyword)
                .itemIdList(itemIdList)
                .build();
    }

    public void changeStatus(SearchKeywordDto searchKeywordDto){
        this.keyword = searchKeywordDto.getKeyword();
        this.itemIdList = searchKeywordDto.getItemIdList();
    }
}
