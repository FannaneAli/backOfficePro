package com.example.backofficepro.service;

import com.example.backofficepro.model.Actor;
import com.example.backofficepro.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    // Ajouter un nouvel acteur
    public Actor addActor(Actor actor) {
        return actorRepository.save(actor);
    }

    // Mettre à jour un acteur existant
    public Actor updateActor(Actor actor) {
        if (actorRepository.existsById(actor.getId())) {
            return actorRepository.save(actor);
        }
        return null;  // L'acteur n'existe pas
    }

    // Supprimer un acteur
    public void deleteActor(Integer id) {
        actorRepository.deleteById(id);
    }

    // Trouver un acteur par son identifiant
    public Optional<Actor> getActorById(Integer id) {
        return actorRepository.findById(id);
    }

    // Filtrer les acteurs par leur nom (recherche partielle)
    public List<Actor> getActorsByName(String name) {
        return actorRepository.findByNameContainingIgnoreCase(name);
    }

    // Obtenir la liste de tous les acteurs
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }
}
