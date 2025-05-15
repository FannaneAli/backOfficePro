package com.example.backofficepro.service;

import com.example.backofficepro.dto.ThemeDTO;

import java.util.List;

public interface IThemeService {



    ThemeDTO getThemeById(Long id);

    List<ThemeDTO> getAllThemes();

    ThemeDTO createTheme(ThemeDTO themeDTO);



    ThemeDTO updateTheme(Long id, ThemeDTO themeDTO);

    void deleteTheme(Long id);
}
