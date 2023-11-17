package com.dons.krohn.controller;

import com.dons.krohn.ApiInformation;
import com.dons.krohn.entity.Category;
import com.dons.krohn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryControllerWithoutMapper {

    private CategoryService categoryService;

    @Autowired
    public CategoryControllerWithoutMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories2")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }


    @DeleteMapping("/categories2/{id}")
    public ApiInformation deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ApiInformation("Delete sucessful.", HttpStatus.OK.value());
    }

}
