package com.example.backofficepro.controller;

import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.orchestration.TVShowOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tv-shows")
public class TVShowController {

    private final TVShowOrchestration tvShowOrchestration;

    public TVShowController(TVShowOrchestration tvShowOrchestration) {
        this.tvShowOrchestration = tvShowOrchestration;
    }

    // Récupérer une série TV par ID
    @GetMapping("/{id}")
    public ResponseEntity<TVShowDTO> getTVShowById(@PathVariable Long id) {
        TVShowDTO tvShowDTO = tvShowOrchestration.getTVShowById(id);
        return tvShowDTO != null ? ResponseEntity.ok(tvShowDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer toutes les séries TV
    @GetMapping
    public ResponseEntity<List<TVShowDTO>> getAllTVShows() {
        List<TVShowDTO> tvShows = tvShowOrchestration.getTVShowsByTitle("");
        return ResponseEntity.ok(tvShows);
    }

    // Créer une nouvelle série TV
    @PostMapping
    public ResponseEntity<TVShowDTO> createTVShow(@RequestBody TVShowDTO tvShowDTO) {
        TVShowDTO createdTVShow = tvShowOrchestration.createTVShow(tvShowDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTVShow);
    }

    // Mettre à jour une série TV
    @PutMapping("/{id}")
    public ResponseEntity<TVShowDTO> updateTVShow(@PathVariable Long id, @RequestBody TVShowDTO tvShowDTO) {
        TVShowDTO updatedTVShow = tvShowOrchestration.updateTVShow(id, tvShowDTO);
        return updatedTVShow != null ? ResponseEntity.ok(updatedTVShow) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer une série TV
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTVShow(@PathVariable Long id) {
        tvShowOrchestration.deleteTVShow(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}