package com.example.backofficepro.controller;

import com.example.backofficepro.dto.MediaThemeAssociationDTO;
import com.example.backofficepro.orchestration.MediaThemeAssociationOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media-theme-associations")
public class MediaThemeAssociationController {

    private final MediaThemeAssociationOrchestration mediaThemeAssociationOrchestration;

    public MediaThemeAssociationController(MediaThemeAssociationOrchestration mediaThemeAssociationOrchestration) {
        this.mediaThemeAssociationOrchestration = mediaThemeAssociationOrchestration;
    }

    // Récupérer une association média-thème par ID
    @GetMapping("/{id}")
    public ResponseEntity<MediaThemeAssociationDTO> getMediaThemeAssociationById(@PathVariable Long id) {
        MediaThemeAssociationDTO associationDTO = mediaThemeAssociationOrchestration.getMediaThemeAssociationById(id);
        return associationDTO != null ? ResponseEntity.ok(associationDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer toutes les associations média-thème
    @GetMapping
    public ResponseEntity<List<MediaThemeAssociationDTO>> getAllMediaThemeAssociations() {
        List<MediaThemeAssociationDTO> associations = mediaThemeAssociationOrchestration.getAllMediaThemeAssociations();
        return ResponseEntity.ok(associations);
    }

    // Créer une nouvelle association média-thème
    @PostMapping
    public ResponseEntity<MediaThemeAssociationDTO> createMediaThemeAssociation(@RequestBody MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        MediaThemeAssociationDTO createdAssociation = mediaThemeAssociationOrchestration.createMediaThemeAssociation(mediaThemeAssociationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssociation);
    }

    // Mettre à jour une association média-thème
    @PutMapping("/{id}")
    public ResponseEntity<MediaThemeAssociationDTO> updateMediaThemeAssociation(@PathVariable Long id, @RequestBody MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        MediaThemeAssociationDTO updatedAssociation = mediaThemeAssociationOrchestration.updateMediaThemeAssociation(id, mediaThemeAssociationDTO);
        return updatedAssociation != null ? ResponseEntity.ok(updatedAssociation) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer une association média-thème
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaThemeAssociation(@PathVariable Long id) {
        mediaThemeAssociationOrchestration.deleteMediaThemeAssociation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}