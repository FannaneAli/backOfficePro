package com.example.backofficepro.controller;

import com.example.backofficepro.dto.MediaNewsAssociationDTO;
import com.example.backofficepro.orchestration.MediaNewsAssociationOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media-news-associations")
public class MediaNewsAssociationController {

    private final MediaNewsAssociationOrchestration mediaNewsAssociationOrchestration;

    public MediaNewsAssociationController(MediaNewsAssociationOrchestration mediaNewsAssociationOrchestration) {
        this.mediaNewsAssociationOrchestration = mediaNewsAssociationOrchestration;
    }

    // Récupérer une association média-actualités par ID
    @GetMapping("/{id}")
    public ResponseEntity<MediaNewsAssociationDTO> getMediaNewsAssociationById(@PathVariable Long id) {
        MediaNewsAssociationDTO associationDTO = mediaNewsAssociationOrchestration.getMediaNewsAssociationById(id);
        return associationDTO != null ? ResponseEntity.ok(associationDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer toutes les associations média-actualités
    @GetMapping
    public ResponseEntity<List<MediaNewsAssociationDTO>> getAllMediaNewsAssociations() {
        List<MediaNewsAssociationDTO> associations = mediaNewsAssociationOrchestration.getAllMediaNewsAssociations();
        return ResponseEntity.ok(associations);
    }

    // Créer une nouvelle association média-actualités
    @PostMapping
    public ResponseEntity<MediaNewsAssociationDTO> createMediaNewsAssociation(@RequestBody MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        MediaNewsAssociationDTO createdAssociation = mediaNewsAssociationOrchestration.createMediaNewsAssociation(mediaNewsAssociationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssociation);
    }

    // Mettre à jour une association média-actualités
    @PutMapping("/{id}")
    public ResponseEntity<MediaNewsAssociationDTO> updateMediaNewsAssociation(@PathVariable Long id, @RequestBody MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        MediaNewsAssociationDTO updatedAssociation = mediaNewsAssociationOrchestration.updateMediaNewsAssociation(id, mediaNewsAssociationDTO);
        return updatedAssociation != null ? ResponseEntity.ok(updatedAssociation) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer une association média-actualités
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaNewsAssociation(@PathVariable Long id) {
        mediaNewsAssociationOrchestration.deleteMediaNewsAssociation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}