package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.CategoryDTO;
import com.example.backofficepro.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryOrchestration {

    @Autowired
    private ICategoryService categoryService;

    public CategoryDTO getCategoryById(Long id) {
        return categoryService.getCategoryById(id);
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        return categoryService.updateCategory(id, categoryDTO);
    }

    public void deleteCategory(Long id) {
        categoryService.deleteCategory(id);
    }
}
