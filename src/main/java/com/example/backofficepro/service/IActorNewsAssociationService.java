package com.example.backofficepro.service;

import com.example.backofficepro.dto.ActorNewsAssociationDTO;

import java.util.List;

public interface IActorNewsAssociationService {

    ActorNewsAssociationDTO getActorNewsAssociationById(Long id);

    List<ActorNewsAssociationDTO> getAllActorNewsAssociations();

    ActorNewsAssociationDTO createActorNewsAssociation(ActorNewsAssociationDTO actorNewsAssociationDTO);

    ActorNewsAssociationDTO updateActorNewsAssociation(Long id, ActorNewsAssociationDTO actorNewsAssociationDTO);

    void deleteActorNewsAssociation(Long id);
}
