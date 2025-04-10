package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.MediaActorAssociationDTO;
import com.example.backofficepro.model.MediaActorAssociation;

import java.util.List;
import java.util.stream.Collectors;

public class MediaActorAssociationMapper {

    public static MediaActorAssociationDTO toDTO(MediaActorAssociation mediaActorAssociation) {
        if (mediaActorAssociation == null) {
            return null;
        }
        return new MediaActorAssociationDTO(
                mediaActorAssociation.getId(),
                ActorMapper.toDTO(mediaActorAssociation.getActor()),
                MediaMapper.toDTO(mediaActorAssociation.getMedia())
        );
    }

    public static MediaActorAssociation toEntity(MediaActorAssociationDTO mediaActorAssociationDTO) {
        if (mediaActorAssociationDTO == null) {
            return null;
        }
        return new MediaActorAssociation(
                mediaActorAssociationDTO.getId(),
                ActorMapper.toEntity(mediaActorAssociationDTO.getActor()),
                MediaMapper.toEntity(mediaActorAssociationDTO.getMedia())
        );
    }

    public static List<MediaActorAssociationDTO> toDTOList(List<MediaActorAssociation> associations) {
        return associations.stream()
                .map(MediaActorAssociationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
