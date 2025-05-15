package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.CategoryDTO;
import com.example.backofficepro.mapper.CategoryMapper;
import com.example.backofficepro.model.Category;
import com.example.backofficepro.repository.CategoryRepository;
import com.example.backofficepro.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Implémentation concrète du service de gestion des catégories.
 * Gère :
 * - La hiérarchie des catégories multimédias
 * - Les opérations de persistence avancées
 * - Le mapping DTO/Entité via CategoryMapper
 */

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper; // Injection du mapper

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(categoryMapper::toDTO).orElse(null);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.toDTOList(categories);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            Category updatedCategory = categoryRepository.save(category);
            return categoryMapper.toDTO(updatedCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
