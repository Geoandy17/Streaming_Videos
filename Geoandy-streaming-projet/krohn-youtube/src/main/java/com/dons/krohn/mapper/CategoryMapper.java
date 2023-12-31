package com.dons.krohn.mapper;


import com.marcinwo.youtubeapi.demo.dto.CategoryDTO;
import com.marcinwo.youtubeapi.demo.entity.Category;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    List<CategoryDTO> toCategoryDTO (Collection<Category> categories);
    CategoryDTO toCategoryDTO(Category category);

    Category toCategoryEntity(CategoryDTO categoryDTO);
}
