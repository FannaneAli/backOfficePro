package com.example.backofficepro.controller;

import com.example.backofficepro.model.Theme;
import com.example.backofficepro.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/themes") // Base URL for all theme-related endpoints
public class ThemeController {

    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    // Endpoint pour ajouter un nouveau thème
    @PostMapping
    public ResponseEntity<Theme> addTheme(@RequestBody Theme theme) {
        Theme savedTheme = themeService.addTheme(theme);
        return new ResponseEntity<>(savedTheme, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un thème existant
    @PutMapping("/{id}")
    public ResponseEntity<Theme> updateTheme(@PathVariable Integer id, @RequestBody Theme theme) {
        theme.setId(id); // Mettre à jour l'ID du thème
        Theme updatedTheme = themeService.updateTheme(theme);
        if (updatedTheme != null) {
            return new ResponseEntity<>(updatedTheme, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si le thème n'existe pas
        }
    }

    // Endpoint pour supprimer un thème
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable Integer id) {
        themeService.deleteTheme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne un code HTTP 204 (No Content)
    }

    // Endpoint pour obtenir un thème par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Theme> getThemeById(@PathVariable Integer id) {
        Optional<Theme> theme = themeService.getThemeById(id);
        return theme.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour récupérer tous les thèmes par leur nom (recherche partielle)
    @GetMapping("/search/name")
    public ResponseEntity<List<Theme>> searchThemesByName(@RequestParam String name) {
        List<Theme> themes = themeService.searchThemesByName(name);
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }

    // Endpoint pour obtenir tous les thèmes
    @GetMapping
    public ResponseEntity<List<Theme>> getAllThemes() {
        List<Theme> themes = themeService.getAllThemes();
        return new ResponseEntity<>(themes, HttpStatus.OK);
    }
}
