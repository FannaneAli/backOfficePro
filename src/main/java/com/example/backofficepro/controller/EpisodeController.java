package com.example.backofficepro.controller;

import com.example.backofficepro.dto.EpisodeDTO;
import com.example.backofficepro.orchestration.EpisodeOrchestration;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {

    private final EpisodeOrchestration episodeOrchestration;

    public EpisodeController(EpisodeOrchestration episodeOrchestration) {
        this.episodeOrchestration = episodeOrchestration;
    }

    // Récupérer un épisode par ID
    @GetMapping("/{id}")
    public ResponseEntity<EpisodeDTO> getEpisodeById(@PathVariable Long id) {
        EpisodeDTO episodeDTO = episodeOrchestration.getEpisodeById(id);
        return episodeDTO != null ? ResponseEntity.ok(episodeDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer tous les épisodes
    @GetMapping
    public ResponseEntity<List<EpisodeDTO>> getAllEpisodes() {
        List<EpisodeDTO> episodes = episodeOrchestration.getAllEpisodes();
        return ResponseEntity.ok(episodes);
    }

    // Créer un nouvel épisode
    @PostMapping
    public ResponseEntity<EpisodeDTO> createEpisode(@Valid @RequestBody EpisodeDTO episodeDTO) {
        EpisodeDTO createdEpisode = episodeOrchestration.createEpisode(episodeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEpisode);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EpisodeDTO> updateEpisode(@PathVariable Long id, @Valid @RequestBody EpisodeDTO episodeDTO) {
        EpisodeDTO updatedEpisode = episodeOrchestration.updateEpisode(id, episodeDTO);
        return updatedEpisode != null ? ResponseEntity.ok(updatedEpisode) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer un épisode
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisode(@PathVariable Long id) {
        try {
            episodeOrchestration.deleteEpisode(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // ✅ Gestion propre de l'erreur
        }
    }
}