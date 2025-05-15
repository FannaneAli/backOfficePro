package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.ActorDTO;
import com.example.backofficepro.mapper.ActorMapper;
import com.example.backofficepro.model.Actor;
import com.example.backofficepro.repository.ActorRepository;
import com.example.backofficepro.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service de gestion métier des acteurs.
 * Fournit les opérations fondamentales pour :
 * - La recherche et la manipulation des profils d'acteurs
 * - La conversion des entités via le mapper dédié
 * - L'intégration avec la couche de persistance
 */


@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorMapper actorMapper; // Injection du mapper

    @Override
    public ActorDTO getActorById(Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.map(actorMapper::toDTO).orElse(null);
    }

    @Override
    public List<ActorDTO> getActorsByName(String name) {
        List<Actor> actors = actorRepository.findAll();
        return actorMapper.toDTOList(actors);
    }

    @Override
    public ActorDTO createActor(ActorDTO actorDTO) {
        Actor actor = actorMapper.toEntity(actorDTO);
        Actor savedActor = actorRepository.save(actor);
        return actorMapper.toDTO(savedActor);
    }

    @Override
    public ActorDTO updateActor(Long id, ActorDTO actorDTO) {
        Optional<Actor> existingActor = actorRepository.findById(id);
        if (existingActor.isPresent()) {
            Actor actor = existingActor.get();
            actor.setName(actorDTO.getName());
            actor.setBiography(actorDTO.getBiography());
            actor.setPhotoUrl(actorDTO.getPhotoUrl());
            Actor updatedActor = actorRepository.save(actor);
            return actorMapper.toDTO(updatedActor);
        }
        return null;
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
