package com.example.backofficepro.controller;

import com.example.backofficepro.model.Episode;
import com.example.backofficepro.model.Season;
import com.example.backofficepro.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/episodes") // Base URL for all episode-related endpoints
public class EpisodeController {

    private final EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    // Endpoint pour ajouter un nouvel épisode
    @PostMapping
    public ResponseEntity<Episode> addEpisode(@RequestBody Episode episode) {
        Episode savedEpisode = episodeService.addEpisode(episode);
        return new ResponseEntity<>(savedEpisode, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un épisode existant
    @PutMapping("/{id}")
    public ResponseEntity<Episode> updateEpisode(@PathVariable Integer id, @RequestBody Episode episode) {
        episode.setId(id);
        Episode updatedEpisode = episodeService.updateEpisode(episode);
        if (updatedEpisode != null) {
            return new ResponseEntity<>(updatedEpisode, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si l'épisode n'existe pas
        }
    }

    // Endpoint pour supprimer un épisode
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisode(@PathVariable Integer id) {
        episodeService.deleteEpisode(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne un code HTTP 204 (No Content)
    }

    // Endpoint pour obtenir un épisode par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Episode> getEpisodeById(@PathVariable Integer id) {
        Optional<Episode> episode = episodeService.getEpisodeById(id);
        return episode.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour obtenir tous les épisodes d'une saison spécifique
    @GetMapping("/season/{seasonId}")
    public ResponseEntity<List<Episode>> getEpisodesBySeason(@PathVariable Integer seasonId) {
        Season season = new Season();
        season.setId(seasonId);  // Assurez-vous que la saison existe dans la base de données avant de l'utiliser.
        List<Episode> episodes = episodeService.getEpisodesBySeason(season);
        if (!episodes.isEmpty()) {
            return new ResponseEntity<>(episodes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Aucun épisode trouvé pour cette saison
        }
    }

    // Endpoint pour obtenir la liste de tous les épisodes
    @GetMapping
    public ResponseEntity<List<Episode>> getAllEpisodes() {
        List<Episode> episodes = episodeService.getAllEpisodes();
        return new ResponseEntity<>(episodes, HttpStatus.OK);
    }
}
