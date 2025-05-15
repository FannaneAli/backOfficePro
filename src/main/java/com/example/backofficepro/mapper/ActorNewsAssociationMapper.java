package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.ActorNewsAssociationDTO;
import com.example.backofficepro.model.ActorNewsAssociation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper pour les associations Acteur/Actualité.
 *
 * <p>Convertit les objets complexes de relation ManyToMany entre :
 * <ul>
 *   <li>{@link ActorNewsAssociation} (Entité JPA)</li>
 *   <li>{@link ActorNewsAssociationDTO} (DTO)</li>
 * </ul>
 *
 * @implNote Gère les relations imbriquées avec les entités liées
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ActorNewsAssociationMapper {

    @Mapping(target = "id", source = "actorNewsAssociation.id")
    @Mapping(target = "actor", source = "actorNewsAssociation.actor")
    @Mapping(target = "news", source = "actorNewsAssociation.news")
    ActorNewsAssociationDTO toDTO(ActorNewsAssociation actorNewsAssociation);

    @Mapping(target = "id", source = "actorNewsAssociationDTO.id")
    @Mapping(target = "actor", source = "actorNewsAssociationDTO.actor")
    @Mapping(target = "news", source = "actorNewsAssociationDTO.news")
    ActorNewsAssociation toEntity(ActorNewsAssociationDTO actorNewsAssociationDTO);

    List<ActorNewsAssociationDTO> toDTOList(List<ActorNewsAssociation> actorNewsAssociations);
}
