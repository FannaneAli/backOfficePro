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

@Service
public class ActorNewsAssociationServiceImpl implements IActorNewsAssociationService {

    @Autowired
    private ActorNewsAssociationRepository actorNewsAssociationRepository;

    @Override
    public ActorNewsAssociationDTO getActorNewsAssociationById(Long id) {
        Optional<ActorNewsAssociation> association = actorNewsAssociationRepository.findById(id);
        return association.map(ActorNewsAssociationMapper::toDTO).orElse(null);
    }

    @Override
    public List<ActorNewsAssociationDTO> getAllActorNewsAssociations() {
        List<ActorNewsAssociation> associations = actorNewsAssociationRepository.findAll();
        return ActorNewsAssociationMapper.toDTOList(associations);
    }

    @Override
    public ActorNewsAssociationDTO createActorNewsAssociation(ActorNewsAssociationDTO actorNewsAssociationDTO) {
        ActorNewsAssociation association = ActorNewsAssociationMapper.toEntity(actorNewsAssociationDTO);
        ActorNewsAssociation savedAssociation = actorNewsAssociationRepository.save(association);
        return ActorNewsAssociationMapper.toDTO(savedAssociation);
    }

    @Override
    public ActorNewsAssociationDTO updateActorNewsAssociation(Long id, ActorNewsAssociationDTO actorNewsAssociationDTO) {
        Optional<ActorNewsAssociation> existingAssociation = actorNewsAssociationRepository.findById(id);
        if (existingAssociation.isPresent()) {
            ActorNewsAssociation association = existingAssociation.get();
            association.setActor(ActorMapper.toEntity(actorNewsAssociationDTO.getActor()));
            association.setNews(NewsMapper.toEntity(actorNewsAssociationDTO.getNews()));
            ActorNewsAssociation updatedAssociation = actorNewsAssociationRepository.save(association);
            return ActorNewsAssociationMapper.toDTO(updatedAssociation);
        }
        return null;
    }

    @Override
    public void deleteActorNewsAssociation(Long id) {
        actorNewsAssociationRepository.deleteById(id);
    }
}
