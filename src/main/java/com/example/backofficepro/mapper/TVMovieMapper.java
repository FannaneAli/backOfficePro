package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.TVMovieDTO;
import com.example.backofficepro.model.TVMovie;
import java.util.List;
import java.util.stream.Collectors;

public class TVMovieMapper {

    public static TVMovieDTO toDTO(TVMovie tvMovie) {
        if (tvMovie == null) {
            return null;
        }
        return new TVMovieDTO(
                tvMovie.getId(),
                tvMovie.getTitle(),
                tvMovie.getRating(),
                tvMovie.getDescription(),
                tvMovie.getPhotoUrl(),
                tvMovie.getReleaseDate(),
                tvMovie.getDuration(),
                tvMovie.getTrailerUrl(),
                tvMovie.getMovieUrl(),
                tvMovie.getPart()
        );
    }

    public static TVMovie toEntity(TVMovieDTO tvMovieDTO) {
        if (tvMovieDTO == null) {
            return null;
        }
        return new TVMovie(
                tvMovieDTO.getId(),
                tvMovieDTO.getTitle(),
                tvMovieDTO.getRating(),
                tvMovieDTO.getDescription(),
                tvMovieDTO.getPhotoUrl(),
                tvMovieDTO.getReleaseDate(),
                tvMovieDTO.getDuration(),
                tvMovieDTO.getTrailerUrl(),
                tvMovieDTO.getMovieUrl(),
                tvMovieDTO.getPart()
        );
    }

    public static List<TVMovieDTO> toDTOList(List<TVMovie> tvMovies) {
        return tvMovies.stream()
                .map(TVMovieMapper::toDTO)
                .collect(Collectors.toList());
    }
}
