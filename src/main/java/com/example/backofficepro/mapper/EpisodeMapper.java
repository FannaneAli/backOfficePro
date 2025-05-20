package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.EpisodeDTO;
import com.example.backofficepro.model.Episode;
import com.example.backofficepro.model.TVShow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Builder;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface EpisodeMapper {

    @Mapping(target = "id", source = "episode.id")
    @Mapping(target = "episodeNumber", source = "episode.episodeNumber")
    @Mapping(target = "title", source = "episode.title")
    @Mapping(target = "description", source = "episode.description")
    @Mapping(target = "photoUrl", source = "episode.photoUrl")
    @Mapping(target = "duration", source = "episode.duration")
    @Mapping(target = "videoUrl", source = "episode.videoUrl")
    @Mapping(target = "seasonNumber", source = "episode.seasonNumber")
    @Mapping(target = "tvShowId", source = "episode.tvShow.id") // Map tvShow.id to tvShowId
    EpisodeDTO toDTO(Episode episode);

    @Mapping(target = "id", source = "episodeDTO.id")
    @Mapping(target = "episodeNumber", source = "episodeDTO.episodeNumber")
    @Mapping(target = "title", source = "episodeDTO.title")
    @Mapping(target = "description", source = "episodeDTO.description")
    @Mapping(target = "photoUrl", source = "episodeDTO.photoUrl")
    @Mapping(target = "duration", source = "episodeDTO.duration")
    @Mapping(target = "videoUrl", source = "episodeDTO.videoUrl")
    @Mapping(target = "seasonNumber", source = "episodeDTO.seasonNumber")
    @Mapping(target = "tvShow", source = "episodeDTO.tvShowId") // Map tvShowId to tvShow
    Episode toEntity(EpisodeDTO episodeDTO);

    List<EpisodeDTO> toDTOList(List<Episode> episodes);
    List<Episode> toEntityList(List<EpisodeDTO> episodeDTOs);

    // Custom mapping for tvShowId to TVShow
    default TVShow map(Long tvShowId) {
        if (tvShowId != null) {
            TVShow tvShow = new TVShow();
            tvShow.setId(tvShowId);
            return tvShow;
        }
        return null;
    }
}
