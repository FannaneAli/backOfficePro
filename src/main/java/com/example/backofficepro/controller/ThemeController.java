package com.example.backofficepro.controller;

import com.example.backofficepro.dto.ThemeDTO;
import com.example.backofficepro.orchestration.ThemeOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
@CrossOrigin(origins = "http://localhost:4200")
public class ThemeController {

    private final ThemeOrchestration themeOrchestration;

    public ThemeController(ThemeOrchestration themeOrchestration) {
        this.themeOrchestration = themeOrchestration;
    }

    // Récupérer un thème par ID
    @GetMapping("/{id}")
    public ResponseEntity<ThemeDTO> getThemeById(@PathVariable Long id) {
        ThemeDTO themeDTO = themeOrchestration.getThemeById(id);
        return themeDTO != null ? ResponseEntity.ok(themeDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer tous les thèmes
    @GetMapping
    public ResponseEntity<List<ThemeDTO>> getAllThemes() {
        List<ThemeDTO> themes = themeOrchestration.getAllThemes();
        return ResponseEntity.ok(themes);
    }

    // Créer un nouveau thème
    @PostMapping
    public ResponseEntity<ThemeDTO> createTheme(@RequestBody ThemeDTO themeDTO) {
        ThemeDTO createdTheme = themeOrchestration.createTheme(themeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTheme);
    }

    // Mettre à jour un thème
    @PutMapping("/{id}")
    public ResponseEntity<ThemeDTO> updateTheme(@PathVariable Long id, @RequestBody ThemeDTO themeDTO) {
        ThemeDTO updatedTheme = themeOrchestration.updateTheme(id, themeDTO);
        return updatedTheme != null ? ResponseEntity.ok(updatedTheme) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer un thème
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable Long id) {
        themeOrchestration.deleteTheme(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}