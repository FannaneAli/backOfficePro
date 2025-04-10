package com.example.backofficepro.service;

import com.example.backofficepro.dto.ActorDTO;

import java.util.List;

public interface IActorService {

    ActorDTO getActorById(Long id);

    List<ActorDTO> getActorsByName(String name);

    ActorDTO createActor(ActorDTO actorDTO);

    ActorDTO updateActor(Long id, ActorDTO actorDTO);

    void deleteActor(Long id);
}
