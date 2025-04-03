package com.example.backofficepro.service;

import com.example.backofficepro.model.Episode;
import com.example.backofficepro.model.Season;
import com.example.backofficepro.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {

    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    // Ajouter une nouvelle saison
    public Season addSeason(Season season) {
        return seasonRepository.save(season);
    }

    // Mettre à jour une saison existante
    public Season updateSeason(Season season) {
        if (seasonRepository.existsById(season.getId())) {
            return seasonRepository.save(season);
        }
        return null;  // Si la saison n'existe pas
    }

    // Supprimer une saison
    public void deleteSeason(Integer id) {
        seasonRepository.deleteById(id);
    }

    // Trouver une saison par son ID
    public Optional<Season> getSeasonById(Integer id) {
        return seasonRepository.findById(id);
    }

    // Récupérer toutes les saisons par numéro de saison
    public List<Season> getSeasonsBySeasonNumber(Integer seasonNumber) {
        return seasonRepository.findBySeasonNumber(seasonNumber);
    }


    // Obtenir toutes les saisons
    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }
}
