package com.example.backofficepro.service;

import com.example.backofficepro.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    CategoryDTO getCategoryById(Long id);

    List<CategoryDTO> getAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);

    void deleteCategory(Long id);
}
