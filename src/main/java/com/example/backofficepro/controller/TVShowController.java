package com.example.backofficepro.controller;

import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.orchestration.TVShowOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tv-shows")
public class TVShowController {

    @Autowired
    private TVShowOrchestration tvShowOrchestration;

    // Récupérer une série TV par ID
    @GetMapping("/{id}")
    public ResponseEntity<TVShowDTO> getTVShowById(@PathVariable Long id) {
        TVShowDTO tvShowDTO = tvShowOrchestration.getTVShowById(id);
        if (tvShowDTO != null) {
            return new ResponseEntity<>(tvShowDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les séries TV
    @GetMapping
    public List<TVShowDTO> getAllTVShows() {
        return tvShowOrchestration.getTVShowsByTitle("");
    }

    // Créer une nouvelle série TV
    @PostMapping
    public ResponseEntity<TVShowDTO> createTVShow(@RequestBody TVShowDTO tvShowDTO) {
        TVShowDTO createdTVShow = tvShowOrchestration.createTVShow(tvShowDTO);
        return new ResponseEntity<>(createdTVShow, HttpStatus.CREATED);
    }

    // Mettre à jour une série TV
    @PutMapping("/{id}")
    public ResponseEntity<TVShowDTO> updateTVShow(@PathVariable Long id, @RequestBody TVShowDTO tvShowDTO) {
        TVShowDTO updatedTVShow = tvShowOrchestration.updateTVShow(id, tvShowDTO);
        if (updatedTVShow != null) {
            return new ResponseEntity<>(updatedTVShow, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une série TV
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTVShow(@PathVariable Long id) {
        tvShowOrchestration.deleteTVShow(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
