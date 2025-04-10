package com.example.backofficepro.controller;

import com.example.backofficepro.dto.SeasonDTO;
import com.example.backofficepro.orchestration.SeasonOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seasons")
public class SeasonController {

    @Autowired
    private SeasonOrchestration seasonOrchestration;

    // Récupérer une saison par ID
    @GetMapping("/{id}")
    public ResponseEntity<SeasonDTO> getSeasonById(@PathVariable Integer id) {
        SeasonDTO seasonDTO = seasonOrchestration.getSeasonById(id);
        if (seasonDTO != null) {
            return new ResponseEntity<>(seasonDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les saisons
    @GetMapping
    public List<SeasonDTO> getAllSeasons() {
        return seasonOrchestration.getAllSeasons();
    }

    // Créer une nouvelle saison
    @PostMapping
    public ResponseEntity<SeasonDTO> createSeason(@RequestBody SeasonDTO seasonDTO) {
        SeasonDTO createdSeason = seasonOrchestration.createSeason(seasonDTO);
        return new ResponseEntity<>(createdSeason, HttpStatus.CREATED);
    }

    // Mettre à jour une saison
    @PutMapping("/{id}")
    public ResponseEntity<SeasonDTO> updateSeason(@PathVariable Integer id, @RequestBody SeasonDTO seasonDTO) {
        SeasonDTO updatedSeason = seasonOrchestration.updateSeason(id, seasonDTO);
        if (updatedSeason != null) {
            return new ResponseEntity<>(updatedSeason, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une saison
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeason(@PathVariable Integer id) {
        seasonOrchestration.deleteSeason(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
