package com.brokurly.dto.categories;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class CategoryDto {
    String codeId;
    String exp;
}
