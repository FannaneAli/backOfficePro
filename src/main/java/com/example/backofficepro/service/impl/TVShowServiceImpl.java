package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.mapper.SeasonMapper;
import com.example.backofficepro.mapper.TVShowMapper;
import com.example.backofficepro.model.TVShow;
import com.example.backofficepro.repository.TVShowRepository;
import com.example.backofficepro.service.ITVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TVShowServiceImpl implements ITVShowService {

    @Autowired
    private TVShowRepository tvShowRepository;

    @Override
    public TVShowDTO getTVShowById(Long id) {
        Optional<TVShow> tvShow = tvShowRepository.findById(id);
        return tvShow.map(TVShowMapper::toDTO).orElse(null);
    }

    @Override
    public List<TVShowDTO> getTVShowsByTitle(String title) {
        // Vous pouvez ajouter une recherche par titre si nécessaire
        List<TVShow> tvShows = tvShowRepository.findAll();
        return TVShowMapper.toDTOList(tvShows);
    }

    @Override
    public TVShowDTO createTVShow(TVShowDTO tvShowDTO) {
        TVShow tvShow = TVShowMapper.toEntity(tvShowDTO);
        TVShow savedTVShow = tvShowRepository.save(tvShow);
        return TVShowMapper.toDTO(savedTVShow);
    }

    @Override
    public TVShowDTO updateTVShow(Long id, TVShowDTO tvShowDTO) {
        Optional<TVShow> existingTVShow = tvShowRepository.findById(id);
        if (existingTVShow.isPresent()) {
            TVShow tvShow = existingTVShow.get();
            tvShow.setTitle(tvShowDTO.getTitle());
            tvShow.setRating(tvShowDTO.getRating());
            tvShow.setDescription(tvShowDTO.getDescription());
            tvShow.setPhotoUrl(tvShowDTO.getPhotoUrl());
            tvShow.setReleaseDate(tvShowDTO.getReleaseDate());
            tvShow.setSeasons(SeasonMapper.toEntityList(tvShowDTO.getSeasons()));
            TVShow updatedTVShow = tvShowRepository.save(tvShow);
            return TVShowMapper.toDTO(updatedTVShow);
        }
        return null;
    }

    @Override
    public void deleteTVShow(Long id) {
        tvShowRepository.deleteById(id);
    }
}
