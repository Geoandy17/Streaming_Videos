package com.dons.krohn.mapper;


import com.dons.krohn.dto.CategoryDTO;
import com.dons.krohn.entity.Category;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;


import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    List<CategoryDTO> toCategoryDTO (Collection<Category> categories);
    CategoryDTO toCategoryDTO(Category category);

    Category toCategoryEntity(CategoryDTO categoryDTO);
}
