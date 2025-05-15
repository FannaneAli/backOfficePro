package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.ThemeDTO;
import com.example.backofficepro.service.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Orchestrateur du référentiel thématique.
 * Facilite :
 * - La gestion de la taxonomie des thèmes
 * - Les opérations de recherche avancée
 * - L'intégration avec les systèmes de tagging
 */


@Component
public class ThemeOrchestration {

    @Autowired
    private IThemeService themeService;

    public ThemeDTO getThemeById(Long id) {
        return themeService.getThemeById(id);
    }

    public List<ThemeDTO> getAllThemes() {
        return themeService.getAllThemes();
    }

    public ThemeDTO createTheme(ThemeDTO themeDTO) {
        return themeService.createTheme(themeDTO);
    }

    public ThemeDTO updateTheme(Long id, ThemeDTO themeDTO) {
        return themeService.updateTheme(id, themeDTO);
    }

    public void deleteTheme(Long id) {
        themeService.deleteTheme(id);
    }
}
