package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.MediaActorAssociationDTO;
import com.example.backofficepro.mapper.ActorMapper;
import com.example.backofficepro.mapper.MediaActorAssociationMapper;
import com.example.backofficepro.mapper.MediaMapper;
import com.example.backofficepro.model.MediaActorAssociation;
import com.example.backofficepro.repository.MediaActorAssociationRepository;
import com.example.backofficepro.service.IMediaActorAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaActorAssociationServiceImpl implements IMediaActorAssociationService {

    @Autowired
    private MediaActorAssociationRepository mediaActorAssociationRepository;

    @Override
    public MediaActorAssociationDTO getMediaActorAssociationById(Long id) {
        Optional<MediaActorAssociation> association = mediaActorAssociationRepository.findById(id);
        return association.map(MediaActorAssociationMapper::toDTO).orElse(null);
    }

    @Override
    public List<MediaActorAssociationDTO> getAllMediaActorAssociations() {
        List<MediaActorAssociation> associations = mediaActorAssociationRepository.findAll();
        return MediaActorAssociationMapper.toDTOList(associations);
    }

    @Override
    public MediaActorAssociationDTO createMediaActorAssociation(MediaActorAssociationDTO mediaActorAssociationDTO) {
        MediaActorAssociation association = MediaActorAssociationMapper.toEntity(mediaActorAssociationDTO);
        MediaActorAssociation savedAssociation = mediaActorAssociationRepository.save(association);
        return MediaActorAssociationMapper.toDTO(savedAssociation);
    }

    @Override
    public MediaActorAssociationDTO updateMediaActorAssociation(Long id, MediaActorAssociationDTO mediaActorAssociationDTO) {
        Optional<MediaActorAssociation> existingAssociation = mediaActorAssociationRepository.findById(id);
        if (existingAssociation.isPresent()) {
            MediaActorAssociation association = existingAssociation.get();
            association.setActor(ActorMapper.toEntity(mediaActorAssociationDTO.getActor()));
            association.setMedia(MediaMapper.toEntity(mediaActorAssociationDTO.getMedia()));
            MediaActorAssociation updatedAssociation = mediaActorAssociationRepository.save(association);
            return MediaActorAssociationMapper.toDTO(updatedAssociation);
        }
        return null;
    }

    @Override
    public void deleteMediaActorAssociation(Long id) {
        mediaActorAssociationRepository.deleteById(id);
    }
}
