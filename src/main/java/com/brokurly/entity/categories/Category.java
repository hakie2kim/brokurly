package com.brokurly.entity.categories;

import com.brokurly.dto.categories.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

<<<<<<< HEAD:src/main/java/com/brokurly/entity/categories/Category.java

=======
import java.util.List;

@ToString
>>>>>>> sookyung:src/main/java/com/brokurly/domain/Category.java
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
