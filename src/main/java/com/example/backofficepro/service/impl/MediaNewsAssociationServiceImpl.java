package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.MediaNewsAssociationDTO;
import com.example.backofficepro.mapper.MediaNewsAssociationMapper;
import com.example.backofficepro.mapper.MediaMapper;
import com.example.backofficepro.mapper.NewsMapper;
import com.example.backofficepro.model.MediaNewsAssociation;
import com.example.backofficepro.repository.MediaNewsAssociationRepository;
import com.example.backofficepro.service.IMediaNewsAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service de gestion des liens médias/actualités.
 * Implémente les mécanismes pour :
 * - Créer des associations cross-domain
 * - Maintenir l'intégrité référentielle
 * - Synchroniser les entités liées
 */


@Service
public class MediaNewsAssociationServiceImpl implements IMediaNewsAssociationService {

    @Autowired
    private MediaNewsAssociationRepository mediaNewsAssociationRepository;

    @Autowired
    private MediaNewsAssociationMapper mediaNewsAssociationMapper; // Injection du mapper

    @Autowired
    private MediaMapper mediaMapper; // Injection du mapper Media

    @Autowired
    private NewsMapper newsMapper; // Injection du mapper News

    @Override
    public MediaNewsAssociationDTO getMediaNewsAssociationById(Long id) {
        Optional<MediaNewsAssociation> association = mediaNewsAssociationRepository.findById(id);
        return association.map(mediaNewsAssociationMapper::toDTO).orElse(null);
    }

    @Override
    public List<MediaNewsAssociationDTO> getAllMediaNewsAssociations() {
        List<MediaNewsAssociation> associations = mediaNewsAssociationRepository.findAll();
        return mediaNewsAssociationMapper.toDTOList(associations);
    }

    @Override
    public MediaNewsAssociationDTO createMediaNewsAssociation(MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        MediaNewsAssociation association = mediaNewsAssociationMapper.toEntity(mediaNewsAssociationDTO);
        MediaNewsAssociation savedAssociation = mediaNewsAssociationRepository.save(association);
        return mediaNewsAssociationMapper.toDTO(savedAssociation);
    }

    @Override
    public MediaNewsAssociationDTO updateMediaNewsAssociation(Long id, MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        Optional<MediaNewsAssociation> existingAssociation = mediaNewsAssociationRepository.findById(id);
        if (existingAssociation.isPresent()) {
            MediaNewsAssociation association = existingAssociation.get();
            association.setMedia(mediaMapper.toEntity(mediaNewsAssociationDTO.getMedia()));
            association.setNews(newsMapper.toEntity(mediaNewsAssociationDTO.getNews()));
            MediaNewsAssociation updatedAssociation = mediaNewsAssociationRepository.save(association);
            return mediaNewsAssociationMapper.toDTO(updatedAssociation);
        }
        return null;
    }

    @Override
    public void deleteMediaNewsAssociation(Long id) {
        mediaNewsAssociationRepository.deleteById(id);
    }
}
