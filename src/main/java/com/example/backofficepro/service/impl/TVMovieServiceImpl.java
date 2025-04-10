package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.TVMovieDTO;
import com.example.backofficepro.mapper.TVMovieMapper;
import com.example.backofficepro.model.TVMovie;
import com.example.backofficepro.repository.TVMovieRepository;
import com.example.backofficepro.service.ITVMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TVMovieServiceImpl implements ITVMovieService {

    @Autowired
    private TVMovieRepository tvMovieRepository;

    @Override
    public TVMovieDTO getTVMovieById(Long id) {
        Optional<TVMovie> tvMovie = tvMovieRepository.findById(id);
        return tvMovie.map(TVMovieMapper::toDTO).orElse(null);
    }

    @Override
    public List<TVMovieDTO> getTVMoviesByTitle(String title) {
        // Vous pouvez ajouter une recherche par titre si nécessaire
        List<TVMovie> tvMovies = tvMovieRepository.findAll();
        return TVMovieMapper.toDTOList(tvMovies);
    }

    @Override
    public TVMovieDTO createTVMovie(TVMovieDTO tvMovieDTO) {
        TVMovie tvMovie = TVMovieMapper.toEntity(tvMovieDTO);
        TVMovie savedTVMovie = tvMovieRepository.save(tvMovie);
        return TVMovieMapper.toDTO(savedTVMovie);
    }

    @Override
    public TVMovieDTO updateTVMovie(Long id, TVMovieDTO tvMovieDTO) {
        Optional<TVMovie> existingTVMovie = tvMovieRepository.findById(id);
        if (existingTVMovie.isPresent()) {
            TVMovie tvMovie = existingTVMovie.get();
            tvMovie.setTitle(tvMovieDTO.getTitle());
            tvMovie.setRating(tvMovieDTO.getRating());
            tvMovie.setDescription(tvMovieDTO.getDescription());
            tvMovie.setPhotoUrl(tvMovieDTO.getPhotoUrl());
            tvMovie.setReleaseDate(tvMovieDTO.getReleaseDate());
            tvMovie.setDuration(tvMovieDTO.getDuration());
            tvMovie.setTrailerUrl(tvMovieDTO.getTrailerUrl());
            tvMovie.setMovieUrl(tvMovieDTO.getMovieUrl());
            tvMovie.setPart(tvMovieDTO.getPart());
            TVMovie updatedTVMovie = tvMovieRepository.save(tvMovie);
            return TVMovieMapper.toDTO(updatedTVMovie);
        }
        return null;
    }

    @Override
    public void deleteTVMovie(Long id) {
        tvMovieRepository.deleteById(id);
    }
}
