package com.example.backofficepro.controller;

import com.example.backofficepro.model.Season;
import com.example.backofficepro.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seasons") // Base URL for all season-related endpoints
public class SeasonController {

    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    // Endpoint pour ajouter une nouvelle saison
    @PostMapping
    public ResponseEntity<Season> addSeason(@RequestBody Season season) {
        Season savedSeason = seasonService.addSeason(season);
        return new ResponseEntity<>(savedSeason, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour une saison existante
    @PutMapping("/{id}")
    public ResponseEntity<Season> updateSeason(@PathVariable Integer id, @RequestBody Season season) {
        season.setId(id); // Mettre à jour l'ID de la saison
        Season updatedSeason = seasonService.updateSeason(season);
        if (updatedSeason != null) {
            return new ResponseEntity<>(updatedSeason, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si la saison n'existe pas
        }
    }

    // Endpoint pour supprimer une saison
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeason(@PathVariable Integer id) {
        seasonService.deleteSeason(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne un code HTTP 204 (No Content)
    }

    // Endpoint pour obtenir une saison par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeasonById(@PathVariable Integer id) {
        Optional<Season> season = seasonService.getSeasonById(id);
        return season.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour récupérer toutes les saisons par numéro de saison
    @GetMapping("/search/seasonNumber")
    public ResponseEntity<List<Season>> getSeasonsBySeasonNumber(@RequestParam Integer seasonNumber) {
        List<Season> seasons = seasonService.getSeasonsBySeasonNumber(seasonNumber);
        return new ResponseEntity<>(seasons, HttpStatus.OK);
    }

    // Endpoint pour obtenir toutes les saisons
    @GetMapping
    public ResponseEntity<List<Season>> getAllSeasons() {
        List<Season> seasons = seasonService.getAllSeasons();
        return new ResponseEntity<>(seasons, HttpStatus.OK);
    }
}
