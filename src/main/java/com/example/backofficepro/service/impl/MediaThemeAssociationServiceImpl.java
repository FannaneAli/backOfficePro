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

@Service
public class MediaThemeAssociationServiceImpl implements IMediaThemeAssociationService {

    @Autowired
    private MediaThemeAssociationRepository mediaThemeAssociationRepository;

    @Override
    public MediaThemeAssociationDTO getMediaThemeAssociationById(Long id) {
        Optional<MediaThemeAssociation> association = mediaThemeAssociationRepository.findById(id);
        return association.map(MediaThemeAssociationMapper::toDTO).orElse(null);
    }

    @Override
    public List<MediaThemeAssociationDTO> getAllMediaThemeAssociations() {
        List<MediaThemeAssociation> associations = mediaThemeAssociationRepository.findAll();
        return MediaThemeAssociationMapper.toDTOList(associations);
    }

    @Override
    public MediaThemeAssociationDTO createMediaThemeAssociation(MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        MediaThemeAssociation association = MediaThemeAssociationMapper.toEntity(mediaThemeAssociationDTO);
        MediaThemeAssociation savedAssociation = mediaThemeAssociationRepository.save(association);
        return MediaThemeAssociationMapper.toDTO(savedAssociation);
    }

    @Override
    public MediaThemeAssociationDTO updateMediaThemeAssociation(Long id, MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        Optional<MediaThemeAssociation> existingAssociation = mediaThemeAssociationRepository.findById(id);
        if (existingAssociation.isPresent()) {
            MediaThemeAssociation association = existingAssociation.get();
            association.setMedia(MediaMapper.toEntity(mediaThemeAssociationDTO.getMedia()));
            association.setTheme(ThemeMapper.toEntity(mediaThemeAssociationDTO.getTheme()));
            MediaThemeAssociation updatedAssociation = mediaThemeAssociationRepository.save(association);
            return MediaThemeAssociationMapper.toDTO(updatedAssociation);
        }
        return null;
    }

    @Override
    public void deleteMediaThemeAssociation(Long id) {
        mediaThemeAssociationRepository.deleteById(id);
    }
}
