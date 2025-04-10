package com.example.backofficepro.controller;

import com.example.backofficepro.dto.EpisodeDTO;
import com.example.backofficepro.orchestration.EpisodeOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {

    @Autowired
    private EpisodeOrchestration episodeOrchestration;

    // Récupérer un épisode par ID
    @GetMapping("/{id}")
    public ResponseEntity<EpisodeDTO> getEpisodeById(@PathVariable Long id) {
        EpisodeDTO episodeDTO = episodeOrchestration.getEpisodeById(id);
        if (episodeDTO != null) {
            return new ResponseEntity<>(episodeDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer tous les épisodes
    @GetMapping
    public List<EpisodeDTO> getAllEpisodes() {
        return episodeOrchestration.getAllEpisodes();
    }

    // Créer un nouvel épisode
    @PostMapping
    public ResponseEntity<EpisodeDTO> createEpisode(@RequestBody EpisodeDTO episodeDTO) {
        EpisodeDTO createdEpisode = episodeOrchestration.createEpisode(episodeDTO);
        return new ResponseEntity<>(createdEpisode, HttpStatus.CREATED);
    }

    // Mettre à jour un épisode
    @PutMapping("/{id}")
    public ResponseEntity<EpisodeDTO> updateEpisode(@PathVariable Long id, @RequestBody EpisodeDTO episodeDTO) {
        EpisodeDTO updatedEpisode = episodeOrchestration.updateEpisode(id, episodeDTO);
        if (updatedEpisode != null) {
            return new ResponseEntity<>(updatedEpisode, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un épisode
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisode(@PathVariable Long id) {
        episodeOrchestration.deleteEpisode(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
