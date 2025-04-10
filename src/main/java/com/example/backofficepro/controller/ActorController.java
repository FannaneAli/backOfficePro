package com.example.backofficepro.controller;

import com.example.backofficepro.dto.ActorDTO;
import com.example.backofficepro.orchestration.ActorOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    @Autowired
    private ActorOrchestration actorOrchestration;

    // Récupérer un acteur par ID
    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActorById(@PathVariable Long id) {
        ActorDTO actorDTO = actorOrchestration.getActorById(id);
        if (actorDTO != null) {
            return new ResponseEntity<>(actorDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer tous les acteurs
    @GetMapping
    public List<ActorDTO> getAllActors() {
        return actorOrchestration.getActorsByName("");
    }

    // Créer un nouvel acteur
    @PostMapping
    public ResponseEntity<ActorDTO> createActor(@RequestBody ActorDTO actorDTO) {
        ActorDTO createdActor = actorOrchestration.createActor(actorDTO);
        return new ResponseEntity<>(createdActor, HttpStatus.CREATED);
    }

    // Mettre à jour un acteur
    @PutMapping("/{id}")
    public ResponseEntity<ActorDTO> updateActor(@PathVariable Long id, @RequestBody ActorDTO actorDTO) {
        ActorDTO updatedActor = actorOrchestration.updateActor(id, actorDTO);
        if (updatedActor != null) {
            return new ResponseEntity<>(updatedActor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer un acteur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorOrchestration.deleteActor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
