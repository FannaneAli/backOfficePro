package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.ActorNewsAssociationDTO;
import com.example.backofficepro.mapper.ActorMapper;
import com.example.backofficepro.mapper.ActorNewsAssociationMapper;
import com.example.backofficepro.mapper.NewsMapper;
import com.example.backofficepro.model.ActorNewsAssociation;
import com.example.backofficepro.repository.ActorNewsAssociationRepository;
import com.example.backofficepro.service.IActorNewsAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service pour la gestion des associations entre acteurs et actualités.
 * Responsable de :
 * - La conversion DTO/Entité via les mappers
 * - La persistance des relations via le repository dédié
 * - La coordination des opérations CRUD complètes
 */


@Service
public class ActorNewsAssociationServiceImpl implements IActorNewsAssociationService {

    @Autowired
    private ActorNewsAssociationRepository actorNewsAssociationRepository;

    @Autowired
    private ActorMapper actorMapper;
    @Autowired
    private  NewsMapper  NewsMapper;

    @Autowired
    private ActorNewsAssociationMapper actorNewsAssociationMapper;

    @Override
    public ActorNewsAssociationDTO getActorNewsAssociationById(Long id) {
        Optional<ActorNewsAssociation> association = actorNewsAssociationRepository.findById(id);
        return association.map(actorNewsAssociationMapper::toDTO).orElse(null);
    }

    @Override
    public List<ActorNewsAssociationDTO> getAllActorNewsAssociations() {
        List<ActorNewsAssociation> associations = actorNewsAssociationRepository.findAll();
        return actorNewsAssociationMapper.toDTOList(associations);
    }

    @Override
    public ActorNewsAssociationDTO createActorNewsAssociation(ActorNewsAssociationDTO actorNewsAssociationDTO) {
        ActorNewsAssociation association = actorNewsAssociationMapper.toEntity(actorNewsAssociationDTO);
        ActorNewsAssociation savedAssociation = actorNewsAssociationRepository.save(association);
        return actorNewsAssociationMapper.toDTO(savedAssociation);
    }

    @Override
    public ActorNewsAssociationDTO updateActorNewsAssociation(Long id, ActorNewsAssociationDTO actorNewsAssociationDTO) {
        Optional<ActorNewsAssociation> existingAssociation = actorNewsAssociationRepository.findById(id);
        if (existingAssociation.isPresent()) {
            ActorNewsAssociation association = existingAssociation.get();
            association.setActor(actorMapper.toEntity(actorNewsAssociationDTO.getActor()));  // Utilisation de l'injection ActorMapper
            association.setNews(NewsMapper.toEntity(actorNewsAssociationDTO.getNews()));
            ActorNewsAssociation updatedAssociation = actorNewsAssociationRepository.save(association);
            return actorNewsAssociationMapper.toDTO(updatedAssociation);
        }
        return null;
    }

    @Override
    public void deleteActorNewsAssociation(Long id) {
        actorNewsAssociationRepository.deleteById(id);
    }
}
