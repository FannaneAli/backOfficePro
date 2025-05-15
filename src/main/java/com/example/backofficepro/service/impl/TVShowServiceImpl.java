package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.mapper.TVShowMapper;
import com.example.backofficepro.model.TVShow;
import com.example.backofficepro.repository.TVShowRepository;
import com.example.backofficepro.service.ITVShowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backofficepro.mapper.EpisodeMapper; // ✅ Vérification de l'import
import java.util.List;
import java.util.Optional;

/**
 * Service pour l'administration des séries télévisées.
 * Coordonne :
 * - La gestion des saisons associées
 * - Les métadonnées de production
 * - La cohérence des données avec le catalogue global
 */


@Slf4j
@Service
public class TVShowServiceImpl implements ITVShowService {

    @Autowired
    private TVShowRepository tvShowRepository;

    @Autowired
    private TVShowMapper tvShowMapper; // Injection du mapper TVShow

    @Autowired
    private EpisodeMapper episodeMapper; // ✅ Ajout du mapper des épisodes
    @Override
    public TVShowDTO getTVShowById(Long id) {
        log.info("getTVShowById");
        Optional<TVShow> tvShow = tvShowRepository.findById(id);
        return tvShow.map(tvShowMapper::toDTO).orElse(null);
    }

    @Override
    public List<TVShowDTO> getTVShowsByTitle(String title) {
        // Vous pouvez ajouter une recherche par titre si nécessaire
        List<TVShow> tvShows = tvShowRepository.findAll();

        return tvShowMapper.toDTOList(tvShows);
    }

    @Override
    public TVShowDTO createTVShow(TVShowDTO tvShowDTO) {
        TVShow tvShow = tvShowMapper.toEntity(tvShowDTO);
        TVShow savedTVShow = tvShowRepository.save(tvShow);
        return tvShowMapper.toDTO(savedTVShow);
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
            tvShow.setEpisodes(episodeMapper.toEntityList(tvShowDTO.getEpisodes())); // ✅ Utilisation de `EpisodeMapper`
            TVShow updatedTVShow = tvShowRepository.save(tvShow);
            return tvShowMapper.toDTO(updatedTVShow);
        }
        return null;
    }

    @Override
    public void deleteTVShow(Long id) {
        tvShowRepository.deleteById(id);
    }
}
