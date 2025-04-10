package com.example.backofficepro.controller;

import com.example.backofficepro.dto.MediaActorAssociationDTO;
import com.example.backofficepro.orchestration.MediaActorAssociationOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media-actor-associations")
public class MediaActorAssociationController {

    @Autowired
    private MediaActorAssociationOrchestration mediaActorAssociationOrchestration;

    // Récupérer une association média-acteur par ID
    @GetMapping("/{id}")
    public ResponseEntity<MediaActorAssociationDTO> getMediaActorAssociationById(@PathVariable Long id) {
        MediaActorAssociationDTO associationDTO = mediaActorAssociationOrchestration.getMediaActorAssociationById(id);
        if (associationDTO != null) {
            return new ResponseEntity<>(associationDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les associations média-acteur
    @GetMapping
    public List<MediaActorAssociationDTO> getAllMediaActorAssociations() {
        return mediaActorAssociationOrchestration.getAllMediaActorAssociations();
    }

    // Créer une nouvelle association média-acteur
    @PostMapping
    public ResponseEntity<MediaActorAssociationDTO> createMediaActorAssociation(@RequestBody MediaActorAssociationDTO mediaActorAssociationDTO) {
        MediaActorAssociationDTO createdAssociation = mediaActorAssociationOrchestration.createMediaActorAssociation(mediaActorAssociationDTO);
        return new ResponseEntity<>(createdAssociation, HttpStatus.CREATED);
    }

    // Mettre à jour une association média-acteur
    @PutMapping("/{id}")
    public ResponseEntity<MediaActorAssociationDTO> updateMediaActorAssociation(@PathVariable Long id, @RequestBody MediaActorAssociationDTO mediaActorAssociationDTO) {
        MediaActorAssociationDTO updatedAssociation = mediaActorAssociationOrchestration.updateMediaActorAssociation(id, mediaActorAssociationDTO);
        if (updatedAssociation != null) {
            return new ResponseEntity<>(updatedAssociation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une association média-acteur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaActorAssociation(@PathVariable Long id) {
        mediaActorAssociationOrchestration.deleteMediaActorAssociation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
