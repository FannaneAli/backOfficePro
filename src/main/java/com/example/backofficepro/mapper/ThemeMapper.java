package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.ThemeDTO;
import com.example.backofficepro.model.Theme;
import java.util.List;
import java.util.stream.Collectors;

public class ThemeMapper {

    public static ThemeDTO toDTO(Theme theme) {
        if (theme == null) {
            return null;
        }
        return new ThemeDTO(
                theme.getId(),
                theme.getName(),
                theme.getDescription()
        );
    }

    public static Theme toEntity(ThemeDTO themeDTO) {
        if (themeDTO == null) {
            return null;
        }
        return new Theme(
                themeDTO.getId(),
                themeDTO.getName(),
                themeDTO.getDescription()
        );
    }

    public static List<ThemeDTO> toDTOList(List<Theme> themes) {
        return themes.stream()
                .map(ThemeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
