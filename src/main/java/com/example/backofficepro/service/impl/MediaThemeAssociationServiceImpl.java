package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.MediaThemeAssociationDTO;
import com.example.backofficepro.mapper.MediaMapper;
import com.example.backofficepro.mapper.MediaThemeAssociationMapper;
import com.example.backofficepro.mapper.ThemeMapper;
import com.example.backofficepro.model.MediaThemeAssociation;
import com.example.backofficepro.repository.MediaThemeAssociationRepository;
import com.example.backofficepro.service.IMediaThemeAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service de thématisation des contenus multimédias.
 * Fournit des fonctionnalités pour :
 * - Associer des thèmes aux médias
 * - Maintenir la cohérence sémantique
 * - Alimenter les systèmes de recommandation
 */


@Service
public class MediaThemeAssociationServiceImpl implements IMediaThemeAssociationService {

    @Autowired
    private MediaThemeAssociationRepository mediaThemeAssociationRepository;

    @Autowired
    private MediaThemeAssociationMapper mediaThemeAssociationMapper; // Injection du mapper

    @Autowired
    private MediaMapper mediaMapper; // Injection du mapper Media

    @Autowired
    private ThemeMapper themeMapper; // Injection du mapper Theme

    @Override
    public MediaThemeAssociationDTO getMediaThemeAssociationById(Long id) {
        Optional<MediaThemeAssociation> association = mediaThemeAssociationRepository.findById(id);
        return association.map(mediaThemeAssociationMapper::toDTO).orElse(null);
    }

    @Override
    public List<MediaThemeAssociationDTO> getAllMediaThemeAssociations() {
        List<MediaThemeAssociation> associations = mediaThemeAssociationRepository.findAll();
        return mediaThemeAssociationMapper.toDTOList(associations);
    }

    @Override
    public MediaThemeAssociationDTO createMediaThemeAssociation(MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        MediaThemeAssociation association = mediaThemeAssociationMapper.toEntity(mediaThemeAssociationDTO);
        MediaThemeAssociation savedAssociation = mediaThemeAssociationRepository.save(association);
        return mediaThemeAssociationMapper.toDTO(savedAssociation);
    }

    @Override
    public MediaThemeAssociationDTO updateMediaThemeAssociation(Long id, MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        Optional<MediaThemeAssociation> existingAssociation = mediaThemeAssociationRepository.findById(id);
        if (existingAssociation.isPresent()) {
            MediaThemeAssociation association = existingAssociation.get();
            association.setMedia(mediaMapper.toEntity(mediaThemeAssociationDTO.getMedia()));
            association.setTheme(themeMapper.toEntity(mediaThemeAssociationDTO.getTheme()));
            MediaThemeAssociation updatedAssociation = mediaThemeAssociationRepository.save(association);
            return mediaThemeAssociationMapper.toDTO(updatedAssociation);
        }
        return null;
    }

    @Override
    public void deleteMediaThemeAssociation(Long id) {
        mediaThemeAssociationRepository.deleteById(id);
    }
}
