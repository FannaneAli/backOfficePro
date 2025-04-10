package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.ThemeDTO;
import com.example.backofficepro.mapper.ThemeMapper;
import com.example.backofficepro.model.Theme;
import com.example.backofficepro.repository.ThemeRepository;
import com.example.backofficepro.service.IThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeServiceImpl implements IThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public ThemeDTO getThemeById(Integer id) {
        Optional<Theme> theme = themeRepository.findById(id);
        return theme.map(ThemeMapper::toDTO).orElse(null);
    }

    @Override
    public List<ThemeDTO> getAllThemes() {
        List<Theme> themes = themeRepository.findAll();
        return ThemeMapper.toDTOList(themes);
    }

    @Override
    public ThemeDTO createTheme(ThemeDTO themeDTO) {
        Theme theme = ThemeMapper.toEntity(themeDTO);
        Theme savedTheme = themeRepository.save(theme);
        return ThemeMapper.toDTO(savedTheme);
    }

    @Override
    public ThemeDTO updateTheme(Integer id, ThemeDTO themeDTO) {
        Optional<Theme> existingTheme = themeRepository.findById(id);
        if (existingTheme.isPresent()) {
            Theme theme = existingTheme.get();
            theme.setName(themeDTO.getName());
            theme.setDescription(themeDTO.getDescription());
            Theme updatedTheme = themeRepository.save(theme);
            return ThemeMapper.toDTO(updatedTheme);
        }
        return null;
    }

    @Override
    public void deleteTheme(Integer id) {
        themeRepository.deleteById(id);
    }
}
