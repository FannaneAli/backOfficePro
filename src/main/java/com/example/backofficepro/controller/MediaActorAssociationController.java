package com.example.backofficepro.controller;

import com.example.backofficepro.dto.MediaActorAssociationDTO;
import com.example.backofficepro.orchestration.MediaActorAssociationOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media-actor-associations")
public class MediaActorAssociationController {

    private final MediaActorAssociationOrchestration mediaActorAssociationOrchestration;

    public MediaActorAssociationController(MediaActorAssociationOrchestration mediaActorAssociationOrchestration) {
        this.mediaActorAssociationOrchestration = mediaActorAssociationOrchestration;
    }

    // Récupérer une association média-acteur par ID
    @GetMapping("/{id}")
    public ResponseEntity<MediaActorAssociationDTO> getMediaActorAssociationById(@PathVariable Long id) {
        MediaActorAssociationDTO associationDTO = mediaActorAssociationOrchestration.getMediaActorAssociationById(id);
        return associationDTO != null ? ResponseEntity.ok(associationDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer toutes les associations média-acteur
    @GetMapping
    public ResponseEntity<List<MediaActorAssociationDTO>> getAllMediaActorAssociations() {
        List<MediaActorAssociationDTO> associations = mediaActorAssociationOrchestration.getAllMediaActorAssociations();
        return ResponseEntity.ok(associations);
    }

    // Créer une nouvelle association média-acteur
    @PostMapping
    public ResponseEntity<MediaActorAssociationDTO> createMediaActorAssociation(@RequestBody MediaActorAssociationDTO mediaActorAssociationDTO) {
        MediaActorAssociationDTO createdAssociation = mediaActorAssociationOrchestration.createMediaActorAssociation(mediaActorAssociationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssociation);
    }

    // Mettre à jour une association média-acteur
    @PutMapping("/{id}")
    public ResponseEntity<MediaActorAssociationDTO> updateMediaActorAssociation(@PathVariable Long id, @RequestBody MediaActorAssociationDTO mediaActorAssociationDTO) {
        MediaActorAssociationDTO updatedAssociation = mediaActorAssociationOrchestration.updateMediaActorAssociation(id, mediaActorAssociationDTO);
        return updatedAssociation != null ? ResponseEntity.ok(updatedAssociation) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer une association média-acteur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaActorAssociation(@PathVariable Long id) {
        mediaActorAssociationOrchestration.deleteMediaActorAssociation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}