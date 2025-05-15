package com.example.backofficepro.controller;

import com.example.backofficepro.dto.MediaDTO;
import com.example.backofficepro.orchestration.MediaOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medias")
public class MediaController {

    private final MediaOrchestration mediaOrchestration;

    public MediaController(MediaOrchestration mediaOrchestration) {
        this.mediaOrchestration = mediaOrchestration;
    }

    // Récupérer un média par ID
    @GetMapping("/{id}")
    public ResponseEntity<MediaDTO> getMediaById(@PathVariable Long id) {
        MediaDTO mediaDTO = mediaOrchestration.getMediaById(id);
        return mediaDTO != null ? ResponseEntity.ok(mediaDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer tous les médias
    @GetMapping
    public ResponseEntity<List<MediaDTO>> getAllMedias() {
        List<MediaDTO> medias = mediaOrchestration.getAllMedia();
        return ResponseEntity.ok(medias);
    }

    // Créer un nouveau média
    @PostMapping
    public ResponseEntity<MediaDTO> createMedia(@RequestBody MediaDTO mediaDTO) {
        MediaDTO createdMedia = mediaOrchestration.createMedia(mediaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMedia);
    }

    // Mettre à jour un média
    @PutMapping("/{id}")
    public ResponseEntity<MediaDTO> updateMedia(@PathVariable Long id, @RequestBody MediaDTO mediaDTO) {
        MediaDTO updatedMedia = mediaOrchestration.updateMedia(id, mediaDTO);
        return updatedMedia != null ? ResponseEntity.ok(updatedMedia) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer un média
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaOrchestration.deleteMedia(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}