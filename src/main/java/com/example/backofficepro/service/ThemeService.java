package com.example.backofficepro.service;

import com.example.backofficepro.model.Theme;
import com.example.backofficepro.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    // Ajouter un nouveau thème
    public Theme addTheme(Theme theme) {
        return themeRepository.save(theme);
    }

    // Mettre à jour un thème existant
    public Theme updateTheme(Theme theme) {
        if (themeRepository.existsById(theme.getId())) {
            return themeRepository.save(theme);
        }
        return null;  // Si le thème n'existe pas
    }

    // Supprimer un thème
    public void deleteTheme(Integer id) {
        themeRepository.deleteById(id);
    }

    // Trouver un thème par son ID
    public Optional<Theme> getThemeById(Integer id) {
        return themeRepository.findById(id);
    }

    // Rechercher des thèmes par leur nom
    public List<Theme> searchThemesByName(String name) {
        return themeRepository.findByNameContainingIgnoreCase(name);
    }

    // Obtenir tous les thèmes
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }
}
