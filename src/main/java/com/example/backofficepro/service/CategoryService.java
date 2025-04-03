package com.example.backofficepro.service;

import com.example.backofficepro.model.Category;
import com.example.backofficepro.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Ajouter une nouvelle catégorie
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Mettre à jour une catégorie existante
    public Category updateCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            return categoryRepository.save(category);
        }
        return null;  // La catégorie n'existe pas
    }

    // Supprimer une catégorie
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    // Trouver une catégorie par son identifiant
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    // Trouver des catégories par leur nom (recherche partielle)
    public List<Category> getCategoriesByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    // Obtenir la liste de toutes les catégories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
