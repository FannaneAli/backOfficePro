package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.TVMovieDTO;
import com.example.backofficepro.model.TVMovie;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import java.util.List;

/**
 * Mapper spécialisé pour les téléfilms et films TV.
 *
 * <p>Convertit les spécificités techniques des téléfilms :
 * <ul>
 *   <li>Métadonnées de diffusion (URLs, durée, partie)</li>
 *   <li>Informations de production complètes</li>
 * </ul>
 *
 * @feature Mapping des URLs média (trailer, film)
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TVMovieMapper {

    @Mapping(target = "id", source = "tvMovie.id")
    @Mapping(target = "title", source = "tvMovie.title")
    @Mapping(target = "rating", source = "tvMovie.rating")
    @Mapping(target = "description", source = "tvMovie.description")
    @Mapping(target = "photoUrl", source = "tvMovie.photoUrl")
    @Mapping(target = "releaseDate", source = "tvMovie.releaseDate")
    @Mapping(target = "duration", source = "tvMovie.duration")
    @Mapping(target = "trailerUrl", source = "tvMovie.trailerUrl")
    @Mapping(target = "movieUrl", source = "tvMovie.movieUrl")
    @Mapping(target = "part", source = "tvMovie.part")
    TVMovieDTO toDTO(TVMovie tvMovie);

    @Mapping(target = "id", source = "tvMovieDTO.id")
    @Mapping(target = "title", source = "tvMovieDTO.title")
    @Mapping(target = "rating", source = "tvMovieDTO.rating")
    @Mapping(target = "description", source = "tvMovieDTO.description")
    @Mapping(target = "photoUrl", source = "tvMovieDTO.photoUrl")
    @Mapping(target = "releaseDate", source = "tvMovieDTO.releaseDate")
    @Mapping(target = "duration", source = "tvMovieDTO.duration")
    @Mapping(target = "trailerUrl", source = "tvMovieDTO.trailerUrl")
    @Mapping(target = "movieUrl", source = "tvMovieDTO.movieUrl")
    @Mapping(target = "part", source = "tvMovieDTO.part")
    TVMovie toEntity(TVMovieDTO tvMovieDTO);

    List<TVMovieDTO> toDTOList(List<TVMovie> tvMovies);
}
