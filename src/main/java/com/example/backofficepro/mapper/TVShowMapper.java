package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.model.TVShow;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import java.util.List;

/**
 * Mapper avancé pour les séries télévisées.
 *
 * <p>Gère les relations complexes avec les saisons :
 * <ul>
 *   <li>Conversion de la liste de saisons</li>
 *   <li>Préservation des références hiérarchiques</li>
 * </ul>
 *
 * @important Garantit la cohérence des données de franchise
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TVShowMapper {

        @Mapping(target = "id", source = "tvShow.id")
        @Mapping(target = "title", source = "tvShow.title")
        @Mapping(target = "rating", source = "tvShow.rating")
        @Mapping(target = "description", source = "tvShow.description")
        @Mapping(target = "photoUrl", source = "tvShow.photoUrl")
        @Mapping(target = "releaseDate", source = "tvShow.releaseDate")
        TVShowDTO toDTO(TVShow tvShow);

        @Mapping(target = "id", source = "tvShowDTO.id")
        @Mapping(target = "title", source = "tvShowDTO.title")
        @Mapping(target = "rating", source = "tvShowDTO.rating")
        @Mapping(target = "description", source = "tvShowDTO.description")
        @Mapping(target = "photoUrl", source = "tvShowDTO.photoUrl")
        @Mapping(target = "releaseDate", source = "tvShowDTO.releaseDate")
        TVShow toEntity(TVShowDTO tvShowDTO);

        List<TVShowDTO> toDTOList(List<TVShow> tvShows);
    }

