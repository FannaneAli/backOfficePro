package com.example.backofficepro.service;

import com.example.backofficepro.model.Episode;
import com.example.backofficepro.model.Season;
import com.example.backofficepro.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    @Autowired
    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    // Ajouter un épisode
    public Episode addEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    // Mettre à jour un épisode
    public Episode updateEpisode(Episode episode) {
        if (episodeRepository.existsById(episode.getId())) {
            return episodeRepository.save(episode);
        }
        return null;  // L'épisode n'existe pas
    }

    // Supprimer un épisode
    public void deleteEpisode(Integer id) {
        episodeRepository.deleteById(id);
    }

    // Trouver un épisode par son ID
    public Optional<Episode> getEpisodeById(Integer id) {
        return episodeRepository.findById(id);
    }

    // Trouver tous les épisodes d'une saison spécifique
    public List<Episode> getEpisodesBySeason(Season season) {
        return episodeRepository.findBySeason(season);
    }

    // Obtenir la liste de tous les épisodes
    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }
}
