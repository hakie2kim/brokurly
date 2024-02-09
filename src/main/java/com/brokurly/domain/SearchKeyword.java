package com.brokurly.domain;


import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SearchKeyword {
    private String keyword;
    private String item_id_list;
}
