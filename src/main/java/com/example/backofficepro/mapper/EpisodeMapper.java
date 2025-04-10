package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.EpisodeDTO;
import com.example.backofficepro.model.Episode;
import java.util.List;
import java.util.stream.Collectors;

public class EpisodeMapper {

    public static EpisodeDTO toDTO(Episode episode) {
        if (episode == null) {
            return null;
        }
        return new EpisodeDTO(
                episode.getId(),
                episode.getEpisodeNumber(),
                episode.getTitle(),
                episode.getDescription(),
                episode.getPhotoUrl(),
                episode.getDuration(),
                episode.getVideoUrl()
        );
    }

    public static Episode toEntity(EpisodeDTO episodeDTO) {
        if (episodeDTO == null) {
            return null;
        }
        return new Episode(
                episodeDTO.getId(),
                episodeDTO.getEpisodeNumber(),
                episodeDTO.getTitle(),
                episodeDTO.getDescription(),
                episodeDTO.getPhotoUrl(),
                episodeDTO.getDuration(),
                episodeDTO.getVideoUrl()
        );
    }

    public static List<EpisodeDTO> toDTOList(List<Episode> episodes) {
        return episodes.stream()
                .map(EpisodeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
