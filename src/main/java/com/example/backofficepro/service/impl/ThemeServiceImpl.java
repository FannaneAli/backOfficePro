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

/**
 * Service d'implémentation pour la gestion des thèmes multimédias.
 * Responsable des opérations CRUD sur les thèmes :
 * - Persistance via ThemeRepository
 * - Conversion DTO/Entité avec ThemeMapper
 * - Gestion de la taxonomie thématique
 */


@Service
public class ThemeServiceImpl implements IThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private ThemeMapper themeMapper; // Injection du mapper

    @Override
    public ThemeDTO getThemeById(Long id) {
        Optional<Theme> theme = themeRepository.findById(id);
        return theme.map(themeMapper::toDTO).orElse(null);
    }

    @Override
    public List<ThemeDTO> getAllThemes() {
        List<Theme> themes = themeRepository.findAll();
        return themeMapper.toDTOList(themes);
    }

    @Override
    public ThemeDTO createTheme(ThemeDTO themeDTO) {
        Theme theme = themeMapper.toEntity(themeDTO);
        Theme savedTheme = themeRepository.save(theme);
        return themeMapper.toDTO(savedTheme);
    }

    @Override
    public ThemeDTO updateTheme(Long id, ThemeDTO themeDTO) {
        Optional<Theme> existingTheme = themeRepository.findById(id);
        if (existingTheme.isPresent()) {
            Theme theme = existingTheme.get();
            theme.setName(themeDTO.getName());
            theme.setDescription(themeDTO.getDescription());
            Theme updatedTheme = themeRepository.save(theme);
            return themeMapper.toDTO(updatedTheme);
        }
        return null;
    }

    @Override
    public void deleteTheme(Long id) {
        themeRepository.deleteById(id);
    }
}
