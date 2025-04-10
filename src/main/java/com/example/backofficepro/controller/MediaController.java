package com.example.backofficepro.controller;

import com.example.backofficepro.dto.MediaDTO;
import com.example.backofficepro.orchestration.MediaOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medias")
public class MediaController {

    @Autowired
    private MediaOrchestration mediaOrchestration;

    // Récupérer un média par ID
    @GetMapping("/{id}")
    public ResponseEntity<MediaDTO> getMediaById(@PathVariable Integer id) {
        MediaDTO mediaDTO = mediaOrchestration.getMediaById(id);
        if (mediaDTO != null) {
            return new ResponseEntity<>(mediaDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer tous les médias
    @GetMapping
    public List<MediaDTO> getAllMedias() {
        return mediaOrchestration.getAllMedia();
    }

    // Créer un nouveau média
    @PostMapping
    public ResponseEntity<MediaDTO> createMedia(@RequestBody MediaDTO mediaDTO) {
        MediaDTO createdMedia = mediaOrchestration.createMedia(mediaDTO);
        return new ResponseEntity<>(createdMedia, HttpStatus.CREATED);
    }

    // Mettre à jour un média
    @PutMapping("/{id}")
    public ResponseEntity<MediaDTO> updateMedia(@PathVariable Integer id, @RequestBody MediaDTO mediaDTO) {
        MediaDTO updatedMedia = mediaOrchestration.updateMedia(id, mediaDTO);
        if (updatedMedia != null) {
            return new ResponseEntity<>(updatedMedia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un média
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Integer id) {
        mediaOrchestration.deleteMedia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
