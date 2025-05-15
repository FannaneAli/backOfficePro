package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.MediaThemeAssociationDTO;
import com.example.backofficepro.model.MediaThemeAssociation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper pour les associations Thèmes/Médias.
 *
 * <p>Convertit les relations de thématisation entre :
 * <ul>
 *   <li>{@link MediaThemeAssociation} (Entité)</li>
 *   <li>{@link MediaThemeAssociationDTO} (DTO)</li>
 * </ul>
 *
 * @keyRole Alimente les systèmes de classification thématique
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MediaThemeAssociationMapper {

    @Mapping(target = "id", source = "mediaThemeAssociation.id")
    @Mapping(target = "media", source = "mediaThemeAssociation.media")
    @Mapping(target = "theme", source = "mediaThemeAssociation.theme")
    MediaThemeAssociationDTO toDTO(MediaThemeAssociation mediaThemeAssociation);

    @Mapping(target = "id", source = "mediaThemeAssociationDTO.id")
    @Mapping(target = "media", source = "mediaThemeAssociationDTO.media")
    @Mapping(target = "theme", source = "mediaThemeAssociationDTO.theme")
    MediaThemeAssociation toEntity(MediaThemeAssociationDTO mediaThemeAssociationDTO);

    List<MediaThemeAssociationDTO> toDTOList(List<MediaThemeAssociation> mediaThemeAssociations);
}
