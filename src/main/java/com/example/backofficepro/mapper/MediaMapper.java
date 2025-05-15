package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.MediaDTO;
import com.example.backofficepro.model.Media;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper central pour les entités multimédias.
 *
 * <p>Gère la conversion complète entre :
 * <ul>
 *   <li>L'entité média {@link Media}</li>
 *   <li>Sa représentation DTO {@link MediaDTO}</li>
 * </ul>
 *
 * @mapping Inclut les métadonnées critiques (titre, date de sortie, rating)
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface MediaMapper {

    @Mapping(target = "id", source = "media.id")
    @Mapping(target = "title", source = "media.title")
    @Mapping(target = "rating", source = "media.rating")
    @Mapping(target = "description", source = "media.description")
    @Mapping(target = "photoUrl", source = "media.photoUrl")
    @Mapping(target = "releaseDate", source = "media.releaseDate")
    MediaDTO toDTO(Media media);

    @Mapping(target = "id", source = "mediaDTO.id")
    @Mapping(target = "title", source = "mediaDTO.title")
    @Mapping(target = "rating", source = "mediaDTO.rating")
    @Mapping(target = "description", source = "mediaDTO.description")
    @Mapping(target = "photoUrl", source = "mediaDTO.photoUrl")
    @Mapping(target = "releaseDate", source = "mediaDTO.releaseDate")
    Media toEntity(MediaDTO mediaDTO);

    List<MediaDTO> toDTOList(List<Media> medias);
}
