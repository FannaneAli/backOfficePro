package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.EpisodeDTO;
import com.example.backofficepro.model.Episode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper spécialisé pour les épisodes de séries.
 *
 * <p>Traduit les données techniques d'épisode entre :
 * <ul>
 *   <li>L'entité {@link Episode}</li>
 *   <li>Le DTO {@link EpisodeDTO}</li>
 * </ul>
 *
 * @feature Mapping des métadonnées multimédias (URLs, durée)
 */

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface EpisodeMapper {

    @Mapping(target = "id", source = "episode.id")
    @Mapping(target = "episodeNumber", source = "episode.episodeNumber")
    @Mapping(target = "title", source = "episode.title")
    @Mapping(target = "description", source = "episode.description")
    @Mapping(target = "photoUrl", source = "episode.photoUrl")
    @Mapping(target = "duration", source = "episode.duration")
    @Mapping(target = "videoUrl", source = "episode.videoUrl")
    EpisodeDTO toDTO(Episode episode);

    @Mapping(target = "id", source = "episodeDTO.id")
    @Mapping(target = "episodeNumber", source = "episodeDTO.episodeNumber")
    @Mapping(target = "title", source = "episodeDTO.title")
    @Mapping(target = "description", source = "episodeDTO.description")
    @Mapping(target = "photoUrl", source = "episodeDTO.photoUrl")
    @Mapping(target = "duration", source = "episodeDTO.duration")
    @Mapping(target = "videoUrl", source = "episodeDTO.videoUrl")
    Episode toEntity(EpisodeDTO episodeDTO);

    List<EpisodeDTO> toDTOList(List<Episode> episodes);
    List<Episode> toEntityList(List<EpisodeDTO> episodeDTOs); // ✅ Ajout du mapping de listes
}