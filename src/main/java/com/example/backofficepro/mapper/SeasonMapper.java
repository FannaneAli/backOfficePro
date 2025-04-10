package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.SeasonDTO;
import com.example.backofficepro.model.Season;
import java.util.List;
import java.util.stream.Collectors;

public class SeasonMapper {

    public static SeasonDTO toDTO(Season season) {
        if (season == null) {
            return null;
        }
        return new SeasonDTO(
                season.getId(),
                season.getReleaseDate(),
                season.getTrailerUrl(),
                season.getPhotoUrl(),
                season.getSeasonNumber(),
                TVShowMapper.toDTO(season.getTvShow())
        );
    }

    public static Season toEntity(SeasonDTO seasonDTO) {
        if (seasonDTO == null) {
            return null;
        }
        return new Season(
                seasonDTO.getId(),
                seasonDTO.getReleaseDate(),
                seasonDTO.getTrailerUrl(),
                seasonDTO.getPhotoUrl(),
                seasonDTO.getSeasonNumber(),
                TVShowMapper.toEntity(seasonDTO.getTvShow())
        );
    }

    public static List<SeasonDTO> toDTOList(List<Season> seasons) {
        return seasons.stream()
                .map(SeasonMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Season> toEntityList(List<SeasonDTO> seasonDTOs) {
        return seasonDTOs.stream()
                .map(SeasonMapper::toEntity)
                .collect(Collectors.toList());
    }
}
