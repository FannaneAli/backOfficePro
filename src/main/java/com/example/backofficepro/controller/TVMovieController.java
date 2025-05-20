package com.example.backofficepro.controller;

import com.example.backofficepro.dto.TVMovieDTO;
import com.example.backofficepro.orchestration.TVMovieOrchestration;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tv-movies")
@CrossOrigin(origins = "http://localhost:4200")
public class TVMovieController {

    private final TVMovieOrchestration tvMovieOrchestration;

    public TVMovieController(TVMovieOrchestration tvMovieOrchestration) {
        this.tvMovieOrchestration = tvMovieOrchestration;
    }

    // Récupérer un film TV par ID
    @GetMapping("/{id}")
    public ResponseEntity<TVMovieDTO> getTVMovieById(@PathVariable Long id) {
        TVMovieDTO tvMovieDTO = tvMovieOrchestration.getTVMovieById(id);
        return tvMovieDTO != null ? ResponseEntity.ok(tvMovieDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer tous les films TV
    @GetMapping
    public ResponseEntity<List<TVMovieDTO>> getAllTVMovies() {
        List<TVMovieDTO> tvMovies = tvMovieOrchestration.getTVMoviesByTitle("").stream()
                .map(tvMovieDTO -> {
                    tvMovieDTO.setCategoryName(tvMovieDTO.getCategoryName()); // ✅ Assure que `categoryName` est bien rempli
                    return tvMovieDTO;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(tvMovies);
    }


    // Créer un nouveau film TV
    @PostMapping
    public ResponseEntity<TVMovieDTO> createTVMovie(@RequestBody TVMovieDTO tvMovieDTO) {
        TVMovieDTO createdTVMovie = tvMovieOrchestration.createTVMovie(tvMovieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTVMovie);
    }

    // Mettre à jour un film TV
    @PutMapping("/{id}")
    public ResponseEntity<TVMovieDTO> updateTVMovie(@PathVariable Long id, @RequestBody TVMovieDTO tvMovieDTO) {
        TVMovieDTO updatedTVMovie = tvMovieOrchestration.updateTVMovie(id, tvMovieDTO);
        return updatedTVMovie != null ? ResponseEntity.ok(updatedTVMovie) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer un film TV
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTVMovie(@PathVariable Long id) {
        try {
            tvMovieOrchestration.deleteTVMovie(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // ✅ Gestion d'erreur
        }
    }
}