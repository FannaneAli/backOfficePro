package com.example.backofficepro.controller;

import com.example.backofficepro.dto.ActorNewsAssociationDTO;
import com.example.backofficepro.orchestration.ActorNewsAssociationOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor-news-associations")
public class ActorNewsAssociationController {

    private final ActorNewsAssociationOrchestration actorNewsAssociationOrchestration;

    public ActorNewsAssociationController(ActorNewsAssociationOrchestration actorNewsAssociationOrchestration) {
        this.actorNewsAssociationOrchestration = actorNewsAssociationOrchestration;
    }

    // Récupérer une association acteur-actualités par ID
    @GetMapping("/{id}")
    public ResponseEntity<ActorNewsAssociationDTO> getActorNewsAssociationById(@PathVariable Long id) {
        ActorNewsAssociationDTO associationDTO = actorNewsAssociationOrchestration.getActorNewsAssociationById(id);
        return associationDTO != null ? ResponseEntity.ok(associationDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer toutes les associations acteur-actualités
    @GetMapping
    public ResponseEntity<List<ActorNewsAssociationDTO>> getAllActorNewsAssociations() {
        List<ActorNewsAssociationDTO> associations = actorNewsAssociationOrchestration.getAllActorNewsAssociations();
        return ResponseEntity.ok(associations);
    }

    // Créer une nouvelle association acteur-actualités
    @PostMapping
    public ResponseEntity<ActorNewsAssociationDTO> createActorNewsAssociation(@RequestBody ActorNewsAssociationDTO actorNewsAssociationDTO) {
        ActorNewsAssociationDTO createdAssociation = actorNewsAssociationOrchestration.createActorNewsAssociation(actorNewsAssociationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssociation);
    }

    // Mettre à jour une association acteur-actualités
    @PutMapping("/{id}")
    public ResponseEntity<ActorNewsAssociationDTO> updateActorNewsAssociation(@PathVariable Long id, @RequestBody ActorNewsAssociationDTO actorNewsAssociationDTO) {
        ActorNewsAssociationDTO updatedAssociation = actorNewsAssociationOrchestration.updateActorNewsAssociation(id, actorNewsAssociationDTO);
        return updatedAssociation != null ? ResponseEntity.ok(updatedAssociation) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer une association acteur-actualités
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActorNewsAssociation(@PathVariable Long id) {
        actorNewsAssociationOrchestration.deleteActorNewsAssociation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}