package com.brokurly.domain;

import com.brokurly.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    String codeId;
    String exp;

    public CategoryDto makeFullDto(){
        return CategoryDto.builder()
                .codeId(codeId)
                .exp(exp)
                .build();
    }
}
