package com.example.backofficepro.controller;

import com.example.backofficepro.model.Actor;
import com.example.backofficepro.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actors") // Base URL for all actor-related endpoints
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    // Endpoint pour ajouter un nouvel acteur
    @PostMapping
    public ResponseEntity<Actor> addActor(@RequestBody Actor actor) {
        Actor savedActor = actorService.addActor(actor);
        return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un acteur existant
    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable Integer id, @RequestBody Actor actor) {
        actor.setId(id);
        Actor updatedActor = actorService.updateActor(actor);
        if (updatedActor != null) {
            return new ResponseEntity<>(updatedActor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si l'acteur n'est pas trouvé
        }
    }

    // Endpoint pour supprimer un acteur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Integer id) {
        actorService.deleteActor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne un code HTTP 204 (No Content)
    }

    // Endpoint pour obtenir un acteur par son identifiant
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Integer id) {
        Optional<Actor> actor = actorService.getActorById(id);
        return actor.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour rechercher des acteurs par leur nom
    @GetMapping("/search")
    public ResponseEntity<List<Actor>> getActorsByName(@RequestParam String name) {
        List<Actor> actors = actorService.getActorsByName(name);
        if (!actors.isEmpty()) {
            return new ResponseEntity<>(actors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Aucun acteur trouvé
        }
    }

    // Endpoint pour obtenir la liste de tous les acteurs
    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors() {
        List<Actor> actors = actorService.getAllActors();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }
}
