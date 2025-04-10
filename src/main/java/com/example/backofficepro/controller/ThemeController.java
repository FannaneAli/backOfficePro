package com.example.backofficepro.controller;

import com.example.backofficepro.dto.ThemeDTO;
import com.example.backofficepro.orchestration.ThemeOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {

    @Autowired
    private ThemeOrchestration themeOrchestration;

    // Récupérer un thème par ID
    @GetMapping("/{id}")
    public ResponseEntity<ThemeDTO> getThemeById(@PathVariable Integer id) {
        ThemeDTO themeDTO = themeOrchestration.getThemeById(id);
        if (themeDTO != null) {
            return new ResponseEntity<>(themeDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer tous les thèmes
    @GetMapping
    public List<ThemeDTO> getAllThemes() {
        return themeOrchestration.getAllThemes();
    }

    // Créer un nouveau thème
    @PostMapping
    public ResponseEntity<ThemeDTO> createTheme(@RequestBody ThemeDTO themeDTO) {
        ThemeDTO createdTheme = themeOrchestration.createTheme(themeDTO);
        return new ResponseEntity<>(createdTheme, HttpStatus.CREATED);
    }

    // Mettre à jour un thème
    @PutMapping("/{id}")
    public ResponseEntity<ThemeDTO> updateTheme(@PathVariable Integer id, @RequestBody ThemeDTO themeDTO) {
        ThemeDTO updatedTheme = themeOrchestration.updateTheme(id, themeDTO);
        if (updatedTheme != null) {
            return new ResponseEntity<>(updatedTheme, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un thème
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable Integer id) {
        themeOrchestration.deleteTheme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
