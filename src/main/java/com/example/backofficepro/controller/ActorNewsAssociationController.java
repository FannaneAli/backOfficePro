package com.example.backofficepro.controller;

import com.example.backofficepro.dto.ActorNewsAssociationDTO;
import com.example.backofficepro.orchestration.ActorNewsAssociationOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor-news-associations")
public class ActorNewsAssociationController {

    @Autowired
    private ActorNewsAssociationOrchestration actorNewsAssociationOrchestration;

    // Récupérer une association acteur-actualités par ID
    @GetMapping("/{id}")
    public ResponseEntity<ActorNewsAssociationDTO> getActorNewsAssociationById(@PathVariable Long id) {
        ActorNewsAssociationDTO associationDTO = actorNewsAssociationOrchestration.getActorNewsAssociationById(id);
        if (associationDTO != null) {
            return new ResponseEntity<>(associationDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les associations acteur-actualités
    @GetMapping
    public List<ActorNewsAssociationDTO> getAllActorNewsAssociations() {
        return actorNewsAssociationOrchestration.getAllActorNewsAssociations();
    }

    // Créer une nouvelle association acteur-actualités
    @PostMapping
    public ResponseEntity<ActorNewsAssociationDTO> createActorNewsAssociation(@RequestBody ActorNewsAssociationDTO actorNewsAssociationDTO) {
        ActorNewsAssociationDTO createdAssociation = actorNewsAssociationOrchestration.createActorNewsAssociation(actorNewsAssociationDTO);
        return new ResponseEntity<>(createdAssociation, HttpStatus.CREATED);
    }

    // Mettre à jour une association acteur-actualités
    @PutMapping("/{id}")
    public ResponseEntity<ActorNewsAssociationDTO> updateActorNewsAssociation(@PathVariable Long id, @RequestBody ActorNewsAssociationDTO actorNewsAssociationDTO) {
        ActorNewsAssociationDTO updatedAssociation = actorNewsAssociationOrchestration.updateActorNewsAssociation(id, actorNewsAssociationDTO);
        if (updatedAssociation != null) {
            return new ResponseEntity<>(updatedAssociation, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une association acteur-actualités
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActorNewsAssociation(@PathVariable Long id) {
        actorNewsAssociationOrchestration.deleteActorNewsAssociation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
