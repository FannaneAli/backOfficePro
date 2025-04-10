package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.model.TVShow;
import java.util.List;
import java.util.stream.Collectors;

public class TVShowMapper {

    public static TVShowDTO toDTO(TVShow tvShow) {
        if (tvShow == null) {
            return null;
        }
        return new TVShowDTO(
                tvShow.getId(),
                tvShow.getTitle(),
                tvShow.getRating(),
                tvShow.getDescription(),
                tvShow.getPhotoUrl(),
                tvShow.getReleaseDate(),
                SeasonMapper.toDTOList(tvShow.getSeasons())
        );
    }

    public static TVShow toEntity(TVShowDTO tvShowDTO) {
        if (tvShowDTO == null) {
            return null;
        }
        return new TVShow(
                tvShowDTO.getId(),
                tvShowDTO.getTitle(),
                tvShowDTO.getRating(),
                tvShowDTO.getDescription(),
                tvShowDTO.getPhotoUrl(),
                tvShowDTO.getReleaseDate(),
                SeasonMapper.toEntityList(tvShowDTO.getSeasons())
        );
    }

    public static List<TVShowDTO> toDTOList(List<TVShow> tvShows) {
        return tvShows.stream()
                .map(TVShowMapper::toDTO)
                .collect(Collectors.toList());
    }
}
