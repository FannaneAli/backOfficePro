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

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public ActorDTO getActorById(Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.map(ActorMapper::toDTO).orElse(null);
    }

    @Override
    public List<ActorDTO> getActorsByName(String name) {
        // Utilisez un critère de recherche pour le nom, si nécessaire
        List<Actor> actors = actorRepository.findAll(); // Remplacez par un critère de recherche si nécessaire
        return ActorMapper.toDTOList(actors);
    }

    @Override
    public ActorDTO createActor(ActorDTO actorDTO) {
        Actor actor = ActorMapper.toEntity(actorDTO);
        Actor savedActor = actorRepository.save(actor);
        return ActorMapper.toDTO(savedActor);
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
            return ActorMapper.toDTO(updatedActor);
        }
        return null;
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }
}
