package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.MediaActorAssociationDTO;
import com.example.backofficepro.mapper.MediaActorAssociationMapper;
import com.example.backofficepro.mapper.MediaMapper;
import com.example.backofficepro.mapper.ActorMapper;
import com.example.backofficepro.model.MediaActorAssociation;
import com.example.backofficepro.repository.MediaActorAssociationRepository;
import com.example.backofficepro.service.IMediaActorAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service d'implémentation pour les crédits d'acteurs dans les médias.
 * Contient la logique métier pour :
 * - L'association/dissociation acteurs-médias
 * - La gestion des relations ManyToMany
 * - La traduction des DTO complexes
 */


@Service
public class MediaActorAssociationServiceImpl implements IMediaActorAssociationService {

    @Autowired
    private MediaActorAssociationRepository mediaActorAssociationRepository;

    @Autowired
    private MediaActorAssociationMapper mediaActorAssociationMapper; // Injection du mapper

    @Autowired
    private MediaMapper mediaMapper; // Injection du mapper Media

    @Autowired
    private ActorMapper actorMapper; // Injection du mapper Actor

    @Override
    public MediaActorAssociationDTO getMediaActorAssociationById(Long id) {
        Optional<MediaActorAssociation> association = mediaActorAssociationRepository.findById(id);
        return association.map(mediaActorAssociationMapper::toDTO).orElse(null);
    }

    @Override
    public List<MediaActorAssociationDTO> getAllMediaActorAssociations() {
        List<MediaActorAssociation> associations = mediaActorAssociationRepository.findAll();
        return mediaActorAssociationMapper.toDTOList(associations);
    }

    @Override
    public MediaActorAssociationDTO createMediaActorAssociation(MediaActorAssociationDTO mediaActorAssociationDTO) {
        MediaActorAssociation association = mediaActorAssociationMapper.toEntity(mediaActorAssociationDTO);
        MediaActorAssociation savedAssociation = mediaActorAssociationRepository.save(association);
        return mediaActorAssociationMapper.toDTO(savedAssociation);
    }

    @Override
    public MediaActorAssociationDTO updateMediaActorAssociation(Long id, MediaActorAssociationDTO mediaActorAssociationDTO) {
        Optional<MediaActorAssociation> existingAssociation = mediaActorAssociationRepository.findById(id);
        if (existingAssociation.isPresent()) {
            MediaActorAssociation association = existingAssociation.get();
            association.setActor(actorMapper.toEntity(mediaActorAssociationDTO.getActor()));
            association.setMedia(mediaMapper.toEntity(mediaActorAssociationDTO.getMedia()));
            MediaActorAssociation updatedAssociation = mediaActorAssociationRepository.save(association);
            return mediaActorAssociationMapper.toDTO(updatedAssociation);
        }
        return null;
    }

    @Override
    public void deleteMediaActorAssociation(Long id) {
        mediaActorAssociationRepository.deleteById(id);
    }
}
