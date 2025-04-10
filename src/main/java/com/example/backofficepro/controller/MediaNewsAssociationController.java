package com.example.backofficepro.controller;

import com.example.backofficepro.dto.MediaNewsAssociationDTO;
import com.example.backofficepro.orchestration.MediaNewsAssociationOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media-news-associations")
public class MediaNewsAssociationController {

    @Autowired
    private MediaNewsAssociationOrchestration mediaNewsAssociationOrchestration;

    // Récupérer une association média-actualités par ID
    @GetMapping("/{id}")
    public ResponseEntity<MediaNewsAssociationDTO> getMediaNewsAssociationById(@PathVariable Long id) {
        MediaNewsAssociationDTO associationDTO = mediaNewsAssociationOrchestration.getMediaNewsAssociationById(id);
        if (associationDTO != null) {
            return new ResponseEntity<>(associationDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les associations média-actualités
    @GetMapping
    public List<MediaNewsAssociationDTO> getAllMediaNewsAssociations() {
        return mediaNewsAssociationOrchestration.getAllMediaNewsAssociations();
    }

    // Créer une nouvelle association média-actualités
    @PostMapping
    public ResponseEntity<MediaNewsAssociationDTO> createMediaNewsAssociation(@RequestBody MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        MediaNewsAssociationDTO createdAssociation = mediaNewsAssociationOrchestration.createMediaNewsAssociation(mediaNewsAssociationDTO);
        return new ResponseEntity<>(createdAssociation, HttpStatus.CREATED);
    }

    // Mettre à jour une association média-actualités
    @PutMapping("/{id}")
    public ResponseEntity<MediaNewsAssociationDTO> updateMediaNewsAssociation(@PathVariable Long id, @RequestBody MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        MediaNewsAssociationDTO updatedAssociation = mediaNewsAssociationOrchestration.updateMediaNewsAssociation(id, mediaNewsAssociationDTO);
        if (updatedAssociation != null) {
            return new ResponseEntity<>(updatedAssociation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une association média-actualités
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaNewsAssociation(@PathVariable Long id) {
        mediaNewsAssociationOrchestration.deleteMediaNewsAssociation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
