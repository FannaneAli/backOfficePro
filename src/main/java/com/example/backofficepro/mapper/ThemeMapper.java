package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.ThemeDTO;
import com.example.backofficepro.model.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import java.util.List;

/**
 * Mapper pour la conversion entre les entités Thème et leur DTO.
 *
 * <p>Gère le mapping bidirectionnel pour :
 * <ul>
 *   <li>La structure de base des thèmes multimédias</li>
 *   <li>Les métadonnées descriptives (nom, description)</li>
 * </ul>
 *
 * @config Intégration Spring avec désactivation des builders Lombok
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ThemeMapper {

    @Mapping(target = "id", source = "theme.id")
    @Mapping(target = "name", source = "theme.name")
    @Mapping(target = "description", source = "theme.description")
    ThemeDTO toDTO(Theme theme);

    @Mapping(target = "id", source = "themeDTO.id")
    @Mapping(target = "name", source = "themeDTO.name")
    @Mapping(target = "description", source = "themeDTO.description")
    Theme toEntity(ThemeDTO themeDTO);

    List<ThemeDTO> toDTOList(List<Theme> themes);
}
