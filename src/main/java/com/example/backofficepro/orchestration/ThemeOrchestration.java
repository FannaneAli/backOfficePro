package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.ThemeDTO;
import com.example.backofficepro.service.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThemeOrchestration {

    @Autowired
    private IThemeService themeService;

    public ThemeDTO getThemeById(Integer id) {
        return themeService.getThemeById(id);
    }

    public List<ThemeDTO> getAllThemes() {
        return themeService.getAllThemes();
    }

    public ThemeDTO createTheme(ThemeDTO themeDTO) {
        return themeService.createTheme(themeDTO);
    }

    public ThemeDTO updateTheme(Integer id, ThemeDTO themeDTO) {
        return themeService.updateTheme(id, themeDTO);
    }

    public void deleteTheme(Integer id) {
        themeService.deleteTheme(id);
    }
}
