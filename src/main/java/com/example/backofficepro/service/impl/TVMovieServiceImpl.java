package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.TVMovieDTO;
import com.example.backofficepro.mapper.TVMovieMapper;
import com.example.backofficepro.model.TVMovie;
import com.example.backofficepro.repository.TVMovieRepository;
import com.example.backofficepro.service.ITVMovieService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service de gestion des téléfilms et films pour la TV.
 * Gère :
 * - Le cycle de vie complet des TV Movies
 * - Les métadonnées spécifiques (durée, URLs média)
 * - L'intégration avec le système de streaming
 */


@Slf4j
@Service
public class TVMovieServiceImpl implements ITVMovieService {

    private final TVMovieRepository tvMovieRepository;
    private final TVMovieMapper tvMovieMapper;  // Injection par constructeur

    // Constructeur
    public TVMovieServiceImpl(TVMovieRepository tvMovieRepository, @Qualifier("TVMovieMapperImpl") TVMovieMapper tvMovieMapper) {
        this.tvMovieRepository = tvMovieRepository;
        this.tvMovieMapper = tvMovieMapper;
    }

    @Override
    public TVMovieDTO getTVMovieById(Long id) {
        log.info("GET TV Movie by id : " + id);
        Optional<TVMovie> tvMovie = tvMovieRepository.findById(id);
        return tvMovie.map(tvMovieMapper::toDTO).orElse(null);
    }

    @Override
    public List<TVMovieDTO> getTVMoviesByTitle(String title) {
        // Vous pouvez ajouter une recherche par titre si nécessaire
        List<TVMovie> tvMovies = tvMovieRepository.findAll();
        return tvMovieMapper.toDTOList(tvMovies);
    }

    @Override
    public TVMovieDTO createTVMovie(TVMovieDTO tvMovieDTO) {
        TVMovie tvMovie = tvMovieMapper.toEntity(tvMovieDTO);
        TVMovie savedTVMovie = tvMovieRepository.save(tvMovie);
        return tvMovieMapper.toDTO(savedTVMovie);
    }

    @Override
    public TVMovieDTO updateTVMovie(Long id, TVMovieDTO tvMovieDTO) {
        Optional<TVMovie> existingTVMovie = tvMovieRepository.findById(id);
        if (existingTVMovie.isPresent()) {
            TVMovie tvMovie = existingTVMovie.get();

            // Vérification et mise à jour de toutes les valeurs
            tvMovie.setTitle(tvMovieDTO.getTitle());
            tvMovie.setRating(tvMovieDTO.getRating() != null ? tvMovieDTO.getRating() : tvMovie.getRating()); // ✅ Vérification
            tvMovie.setDescription(tvMovieDTO.getDescription() != null ? tvMovieDTO.getDescription() : tvMovie.getDescription());
            tvMovie.setPhotoUrl(tvMovieDTO.getPhotoUrl() != null ? tvMovieDTO.getPhotoUrl() : tvMovie.getPhotoUrl());
            tvMovie.setReleaseDate(tvMovieDTO.getReleaseDate() != null ? tvMovieDTO.getReleaseDate() : tvMovie.getReleaseDate());
            tvMovie.setDuration(tvMovieDTO.getDuration() != null ? Math.toIntExact(tvMovieDTO.getDuration()) : tvMovie.getDuration());
            tvMovie.setTrailerUrl(tvMovieDTO.getTrailerUrl() != null ? tvMovieDTO.getTrailerUrl() : tvMovie.getTrailerUrl());
            tvMovie.setMovieUrl(tvMovieDTO.getMovieUrl() != null ? tvMovieDTO.getMovieUrl() : tvMovie.getMovieUrl());
            tvMovie.setPart(tvMovieDTO.getPart() != null ? tvMovieDTO.getPart() : tvMovie.getPart());
            tvMovie.setDirector(tvMovieDTO.getDirector() != null ? tvMovieDTO.getDirector() : tvMovie.getDirector());
            tvMovie.setProductionCompany(tvMovieDTO.getProductionCompany() != null ? tvMovieDTO.getProductionCompany() : tvMovie.getProductionCompany());
            tvMovie.setCategoryAge(tvMovieDTO.getCategoryAge() != null ? tvMovieDTO.getCategoryAge() : tvMovie.getCategoryAge());
            tvMovie.setLanguage(tvMovieDTO.getLanguage() != null ? tvMovieDTO.getLanguage() : tvMovie.getLanguage());

            TVMovie updatedTVMovie = tvMovieRepository.save(tvMovie);
            return tvMovieMapper.toDTO(updatedTVMovie);
        } else {
            throw new EntityNotFoundException("TV Movie non trouvé avec l'ID : " + id);
        }
    }

    @Override
    public void deleteTVMovie(Long id) {
        if (tvMovieRepository.existsById(id)) {
            tvMovieRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("TV Movie non trouvé avec l'ID : " + id); // ✅ Exception
        }
    }
}
