package com.example.backofficepro.controller;

import com.example.backofficepro.dto.TVMovieDTO;
import com.example.backofficepro.orchestration.TVMovieOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tv-movies")
public class TVMovieController {

    @Autowired
    private TVMovieOrchestration tvMovieOrchestration;

    // Récupérer un film TV par ID
    @GetMapping("/{id}")
    public ResponseEntity<TVMovieDTO> getTVMovieById(@PathVariable Long id) {
        TVMovieDTO tvMovieDTO = tvMovieOrchestration.getTVMovieById(id);
        if (tvMovieDTO != null) {
            return new ResponseEntity<>(tvMovieDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer tous les films TV
    @GetMapping
    public List<TVMovieDTO> getAllTVMovies() {
        return tvMovieOrchestration.getTVMoviesByTitle("");
    }

    // Créer un nouveau film TV
    @PostMapping
    public ResponseEntity<TVMovieDTO> createTVMovie(@RequestBody TVMovieDTO tvMovieDTO) {
        TVMovieDTO createdTVMovie = tvMovieOrchestration.createTVMovie(tvMovieDTO);
        return new ResponseEntity<>(createdTVMovie, HttpStatus.CREATED);
    }

    // Mettre à jour un film TV
    @PutMapping("/{id}")
    public ResponseEntity<TVMovieDTO> updateTVMovie(@PathVariable Long id, @RequestBody TVMovieDTO tvMovieDTO) {
        TVMovieDTO updatedTVMovie = tvMovieOrchestration.updateTVMovie(id, tvMovieDTO);
        if (updatedTVMovie != null) {
            return new ResponseEntity<>(updatedTVMovie, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un film TV
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTVMovie(@PathVariable Long id) {
        tvMovieOrchestration.deleteTVMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
