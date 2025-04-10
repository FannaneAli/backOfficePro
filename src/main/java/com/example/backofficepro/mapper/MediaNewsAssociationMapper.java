package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.MediaNewsAssociationDTO;
import com.example.backofficepro.model.MediaNewsAssociation;

import java.util.List;
import java.util.stream.Collectors;

public class MediaNewsAssociationMapper {

    public static MediaNewsAssociationDTO toDTO(MediaNewsAssociation mediaNewsAssociation) {
        if (mediaNewsAssociation == null) {
            return null;
        }
        return new MediaNewsAssociationDTO(
                mediaNewsAssociation.getId(),
                MediaMapper.toDTO(mediaNewsAssociation.getMedia()),
                NewsMapper.toDTO(mediaNewsAssociation.getNews())
        );
    }

    public static MediaNewsAssociation toEntity(MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        if (mediaNewsAssociationDTO == null) {
            return null;
        }
        return new MediaNewsAssociation(
                mediaNewsAssociationDTO.getId(),
                MediaMapper.toEntity(mediaNewsAssociationDTO.getMedia()),
                NewsMapper.toEntity(mediaNewsAssociationDTO.getNews())
        );
    }

    public static List<MediaNewsAssociationDTO> toDTOList(List<MediaNewsAssociation> associations) {
        return associations.stream()
                .map(MediaNewsAssociationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
