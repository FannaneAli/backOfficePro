package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.MediaThemeAssociationDTO;
import com.example.backofficepro.model.MediaThemeAssociation;

import java.util.List;
import java.util.stream.Collectors;

public class MediaThemeAssociationMapper {

    public static MediaThemeAssociationDTO toDTO(MediaThemeAssociation mediaThemeAssociation) {
        if (mediaThemeAssociation == null) {
            return null;
        }
        return new MediaThemeAssociationDTO(
                mediaThemeAssociation.getId(),
                MediaMapper.toDTO(mediaThemeAssociation.getMedia()),
                ThemeMapper.toDTO(mediaThemeAssociation.getTheme())
        );
    }

    public static MediaThemeAssociation toEntity(MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        if (mediaThemeAssociationDTO == null) {
            return null;
        }
        return new MediaThemeAssociation(
                mediaThemeAssociationDTO.getId(),
                MediaMapper.toEntity(mediaThemeAssociationDTO.getMedia()),
                ThemeMapper.toEntity(mediaThemeAssociationDTO.getTheme())
        );
    }

    public static List<MediaThemeAssociationDTO> toDTOList(List<MediaThemeAssociation> associations) {
        return associations.stream()
                .map(MediaThemeAssociationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
