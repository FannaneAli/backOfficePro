package com.example.backofficepro.controller;

import com.example.backofficepro.dto.ActorDTO;
import com.example.backofficepro.orchestration.ActorOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorOrchestration actorOrchestration;

    public ActorController(ActorOrchestration actorOrchestration) {
        this.actorOrchestration = actorOrchestration;
    }

    // Récupérer un acteur par ID
    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActorById(@PathVariable Long id) {
        ActorDTO actorDTO = actorOrchestration.getActorById(id);
        return actorDTO != null ? ResponseEntity.ok(actorDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer tous les acteurs
    @GetMapping
    public ResponseEntity<List<ActorDTO>> getAllActors() {
        List<ActorDTO> actors = actorOrchestration.getActorsByName("");
        return ResponseEntity.ok(actors);
    }

    // Créer un acteur
    @PostMapping
    public ResponseEntity<ActorDTO> createActor(@RequestBody ActorDTO actorDTO) {
        ActorDTO createdActor = actorOrchestration.createActor(actorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdActor);
    }

    // Mettre à jour un acteur
    @PutMapping("/{id}")
    public ResponseEntity<ActorDTO> updateActor(@PathVariable Long id, @RequestBody ActorDTO actorDTO) {
        ActorDTO updatedActor = actorOrchestration.updateActor(id, actorDTO);
        return updatedActor != null ? ResponseEntity.ok(updatedActor) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer un acteur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorOrchestration.deleteActor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}