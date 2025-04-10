package com.example.backofficepro.controller;

import com.example.backofficepro.dto.MediaThemeAssociationDTO;
import com.example.backofficepro.orchestration.MediaThemeAssociationOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media-theme-associations")
public class MediaThemeAssociationController {

    @Autowired
    private MediaThemeAssociationOrchestration mediaThemeAssociationOrchestration;

    // Récupérer une association média-thème par ID
    @GetMapping("/{id}")
    public ResponseEntity<MediaThemeAssociationDTO> getMediaThemeAssociationById(@PathVariable Long id) {
        MediaThemeAssociationDTO associationDTO = mediaThemeAssociationOrchestration.getMediaThemeAssociationById(id);
        if (associationDTO != null) {
            return new ResponseEntity<>(associationDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les associations média-thème
    @GetMapping
    public List<MediaThemeAssociationDTO> getAllMediaThemeAssociations() {
        return mediaThemeAssociationOrchestration.getAllMediaThemeAssociations();
    }

    // Créer une nouvelle association média-thème
    @PostMapping
    public ResponseEntity<MediaThemeAssociationDTO> createMediaThemeAssociation(@RequestBody MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        MediaThemeAssociationDTO createdAssociation = mediaThemeAssociationOrchestration.createMediaThemeAssociation(mediaThemeAssociationDTO);
        return new ResponseEntity<>(createdAssociation, HttpStatus.CREATED);
    }

    // Mettre à jour une association média-thème
    @PutMapping("/{id}")
    public ResponseEntity<MediaThemeAssociationDTO> updateMediaThemeAssociation(@PathVariable Long id, @RequestBody MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        MediaThemeAssociationDTO updatedAssociation = mediaThemeAssociationOrchestration.updateMediaThemeAssociation(id, mediaThemeAssociationDTO);
        if (updatedAssociation != null) {
            return new ResponseEntity<>(updatedAssociation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une association média-thème
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMediaThemeAssociation(@PathVariable Long id) {
        mediaThemeAssociationOrchestration.deleteMediaThemeAssociation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
