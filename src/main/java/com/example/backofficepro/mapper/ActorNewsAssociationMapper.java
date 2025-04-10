package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.ActorNewsAssociationDTO;
import com.example.backofficepro.model.ActorNewsAssociation;

import java.util.List;
import java.util.stream.Collectors;

public class ActorNewsAssociationMapper {

    public static ActorNewsAssociationDTO toDTO(ActorNewsAssociation actorNewsAssociation) {
        if (actorNewsAssociation == null) {
            return null;
        }
        return new ActorNewsAssociationDTO(
                actorNewsAssociation.getId(),
                ActorMapper.toDTO(actorNewsAssociation.getActor()),
                NewsMapper.toDTO(actorNewsAssociation.getNews())
        );
    }

    public static ActorNewsAssociation toEntity(ActorNewsAssociationDTO actorNewsAssociationDTO) {
        if (actorNewsAssociationDTO == null) {
            return null;
        }
        return new ActorNewsAssociation(
                actorNewsAssociationDTO.getId(),
                ActorMapper.toEntity(actorNewsAssociationDTO.getActor()),
                NewsMapper.toEntity(actorNewsAssociationDTO.getNews())
        );
    }

    public static List<ActorNewsAssociationDTO> toDTOList(List<ActorNewsAssociation> actorNewsAssociations) {
        return actorNewsAssociations.stream()
                .map(ActorNewsAssociationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
