package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.MediaDTO;
import com.example.backofficepro.mapper.MediaMapper;
import com.example.backofficepro.model.Media;
import com.example.backofficepro.repository.MediaRepository;
import com.example.backofficepro.service.IMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service principal pour l'administration du catalogue multimédias.
 * Encapsule :
 * - La logique de gestion des assets média
 * - Les règles de gestion spécifiques aux médias
 * - Les interactions avec le système de stockage
 */


@Slf4j
@Service
public class MediaServiceImpl implements IMediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MediaMapper mediaMapper; // Injection du mapper

    @Override
    public MediaDTO getMediaById(Long id) {
        Optional<Media> media = mediaRepository.findById(id);
        return media.map(mediaMapper::toDTO).orElse(null);
    }

    @Override
    public List<MediaDTO> getAllMedia() {
        List<Media> medias = mediaRepository.findAll();
        return mediaMapper.toDTOList(medias);
    }

    @Override
    public MediaDTO createMedia(MediaDTO mediaDTO) {
        Media media = mediaMapper.toEntity(mediaDTO);
        Media savedMedia = mediaRepository.save(media);
        return mediaMapper.toDTO(savedMedia);
    }

    @Override
    public MediaDTO updateMedia(Long id, MediaDTO mediaDTO) {
        Optional<Media> existingMedia = mediaRepository.findById(id);
        if (existingMedia.isPresent()) {
            Media media = existingMedia.get();
            media.setTitle(mediaDTO.getTitle());
            media.setRating(mediaDTO.getRating());
            media.setDescription(mediaDTO.getDescription());
            media.setPhotoUrl(mediaDTO.getPhotoUrl());
            media.setReleaseDate(mediaDTO.getReleaseDate());
            Media updatedMedia = mediaRepository.save(media);
            return mediaMapper.toDTO(updatedMedia);
        }
        return null;
    }

    @Override
    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }
}
