package com.example.backofficepro.controller;

import com.example.backofficepro.dto.CategoryDTO;
import com.example.backofficepro.orchestration.CategoryOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryOrchestration categoryOrchestration;

    public CategoryController(CategoryOrchestration categoryOrchestration) {
        this.categoryOrchestration = categoryOrchestration;
    }

    // Récupérer une catégorie par ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryOrchestration.getCategoryById(id);
        return categoryDTO != null ? ResponseEntity.ok(categoryDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer toutes les catégories
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = categoryOrchestration.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    // Créer une nouvelle catégorie
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO createdCategory = categoryOrchestration.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    // Mettre à jour une catégorie
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO updatedCategory = categoryOrchestration.updateCategory(id, categoryDTO);
        return updatedCategory != null ? ResponseEntity.ok(updatedCategory) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer une catégorie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryOrchestration.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}