package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.EpisodeDTO;
import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.mapper.TVShowMapper;
import com.example.backofficepro.model.Category;
import com.example.backofficepro.model.Episode;
import com.example.backofficepro.model.TVShow;
import com.example.backofficepro.repository.CategoryRepository;
import com.example.backofficepro.repository.TVShowRepository;
import com.example.backofficepro.service.ITVShowService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    private final TVShowRepository tvShowRepository;
    private final CategoryRepository categoryRepository;
    private final TVShowMapper tvShowMapper;
    private final EpisodeMapper episodeMapper;

    // Constructor-based injection
    @Autowired
    public TVShowServiceImpl(TVShowRepository tvShowRepository,
                             CategoryRepository categoryRepository,
                             @Qualifier("TVShowMapperImpl") TVShowMapper tvShowMapper,
                             EpisodeMapper episodeMapper) {
        this.tvShowRepository = tvShowRepository;
        this.categoryRepository = categoryRepository;
        this.tvShowMapper = tvShowMapper;
        this.episodeMapper = episodeMapper;
    }

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
        Optional<TVShow> existingTVShowOpt = tvShowRepository.findById(id);

        if (existingTVShowOpt.isPresent()) {
            TVShow tvShow = existingTVShowOpt.get();

            // ✅ Mise à jour des champs principaux
            tvShow.setTitle(tvShowDTO.getTitle());
            tvShow.setRating(tvShowDTO.getRating());
            tvShow.setDescription(tvShowDTO.getDescription());
            tvShow.setPhotoUrl(tvShowDTO.getPhotoUrl());
            tvShow.setReleaseDate(tvShowDTO.getReleaseDate());
            tvShow.setDirector(tvShowDTO.getDirector());
            tvShow.setProductionCompany(tvShowDTO.getProductionCompany());
            tvShow.setCategoryAge(tvShowDTO.getCategoryAge());
            tvShow.setLanguage(tvShowDTO.getLanguage());

            // ✅ Mise à jour de la catégorie
            Category category = categoryRepository.findById(tvShowDTO.getCategoryId())
                    .orElseThrow(() -> new EntityNotFoundException("Catégorie non trouvée avec ID: " + tvShowDTO.getCategoryId()));
            tvShow.setCategory(category);

            // ✅ Mise à jour des épisodes sans déclencher la suppression des anciens
            if (tvShowDTO.getEpisodes() != null) {
                tvShow.getEpisodes().clear();  // Supprime uniquement la référence, pas les objets
                for (EpisodeDTO episodeDTO : tvShowDTO.getEpisodes()) {
                    Episode episode = episodeMapper.toEntity(episodeDTO);
                    episode.setTvShow(tvShow);  // ✅ Associe correctement l'épisode à la série TV
                    tvShow.getEpisodes().add(episode);
                }
            }

            // ✅ Sauvegarde et conversion en DTO
            TVShow updatedTVShow = tvShowRepository.save(tvShow);
            return tvShowMapper.toDTO(updatedTVShow);
        }

        throw new EntityNotFoundException("Série TV non trouvée avec ID: " + id);
    }



    @Override
    public void deleteTVShow(Long id) {
        tvShowRepository.deleteById(id);
    }
}
