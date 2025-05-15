package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.MediaNewsAssociationDTO;
import com.example.backofficepro.model.MediaNewsAssociation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper pour les associations Médias/Actualités.
 *
 * <p>Traduit les relations cross-domain entre :
 * <ul>
 *   <li>{@link MediaNewsAssociation} (Entité)</li>
 *   <li>{@link MediaNewsAssociationDTO} (DTO)</li>
 * </ul>
 *
 * @note Garantit la cohérence des références croisées
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MediaNewsAssociationMapper {

    @Mapping(target = "id", source = "mediaNewsAssociation.id")
    @Mapping(target = "media", source = "mediaNewsAssociation.media")
    @Mapping(target = "news", source = "mediaNewsAssociation.news")
    MediaNewsAssociationDTO toDTO(MediaNewsAssociation mediaNewsAssociation);

    @Mapping(target = "id", source = "mediaNewsAssociationDTO.id")
    @Mapping(target = "media", source = "mediaNewsAssociationDTO.media")
    @Mapping(target = "news", source = "mediaNewsAssociationDTO.news")
    MediaNewsAssociation toEntity(MediaNewsAssociationDTO mediaNewsAssociationDTO);

    List<MediaNewsAssociationDTO> toDTOList(List<MediaNewsAssociation> mediaNewsAssociations);
}
