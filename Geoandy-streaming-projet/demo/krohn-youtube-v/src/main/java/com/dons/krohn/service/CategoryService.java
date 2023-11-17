package com.dons.krohn.service;

import com.dons.krohn.dto.PatchCategoryDTO;
import com.dons.krohn.entity.Category;
import com.dons.krohn.exeption.CategoryNotFoundException;
import com.dons.krohn.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("Category not found."));
    }

    public Category postCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
    }

    public Category updateCategoryById(Long id, PatchCategoryDTO patchCategoryDTO){
        Category category = findCategoryById(id);
        category.setName(patchCategoryDTO.getName());
        return categoryRepository.save(category);
    }
}
