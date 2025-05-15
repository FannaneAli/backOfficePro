package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.MediaActorAssociationDTO;
import com.example.backofficepro.model.MediaActorAssociation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper pour les crédits d'acteurs dans les médias.
 *
 * <p>Convertit les relations ManyToMany entre :
 * <ul>
 *   <li>{@link MediaActorAssociation} (Entité)</li>
 *   <li>{@link MediaActorAssociationDTO} (DTO)</li>
 * </ul>
 *
 * @important Préserve les relations bidirectionnelles
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MediaActorAssociationMapper {

    @Mapping(target = "id", source = "mediaActorAssociation.id")
    @Mapping(target = "actor", source = "mediaActorAssociation.actor")
    @Mapping(target = "media", source = "mediaActorAssociation.media")
    MediaActorAssociationDTO toDTO(MediaActorAssociation mediaActorAssociation);

    @Mapping(target = "id", source = "mediaActorAssociationDTO.id")
    @Mapping(target = "actor", source = "mediaActorAssociationDTO.actor")
    @Mapping(target = "media", source = "mediaActorAssociationDTO.media")
    MediaActorAssociation toEntity(MediaActorAssociationDTO mediaActorAssociationDTO);

    List<MediaActorAssociationDTO> toDTOList(List<MediaActorAssociation> mediaActorAssociations);
}
