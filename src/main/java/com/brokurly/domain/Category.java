package com.brokurly.domain;

import com.brokurly.dto.CategoryDto;
import com.brokurly.dto.ReceiverDetailsDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private String codeId;
    private String exp;


    public CategoryDto makeDto() {
        return CategoryDto.builder()
                .exp(exp)
                .codeId(codeId)
                .build();
    }

}