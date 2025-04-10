package com.example.backofficepro.service;

import com.example.backofficepro.dto.ThemeDTO;

import java.util.List;

public interface IThemeService {



    ThemeDTO getThemeById(Integer id);

    List<ThemeDTO> getAllThemes();

    ThemeDTO createTheme(ThemeDTO themeDTO);



    ThemeDTO updateTheme(Integer id, ThemeDTO themeDTO);

    void deleteTheme(Integer id);
}
