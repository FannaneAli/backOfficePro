package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.MediaDTO;
import com.example.backofficepro.mapper.MediaMapper;
import com.example.backofficepro.model.Media;
import com.example.backofficepro.repository.MediaRepository;
import com.example.backofficepro.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaServiceImpl implements IMediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public MediaDTO getMediaById(Integer id) {
        Optional<Media> media = mediaRepository.findById(id);
        return media.map(MediaMapper::toDTO).orElse(null);
    }

    @Override
    public List<MediaDTO> getAllMedia() {
        List<Media> medias = mediaRepository.findAll();
        return MediaMapper.toDTOList(medias);
    }

    @Override
    public MediaDTO createMedia(MediaDTO mediaDTO) {
        Media media = MediaMapper.toEntity(mediaDTO);
        Media savedMedia = mediaRepository.save(media);
        return MediaMapper.toDTO(savedMedia);
    }

    @Override
    public MediaDTO updateMedia(Integer id, MediaDTO mediaDTO) {
        Optional<Media> existingMedia = mediaRepository.findById(id);
        if (existingMedia.isPresent()) {
            Media media = existingMedia.get();
            media.setTitle(mediaDTO.getTitle());
            media.setRating(mediaDTO.getRating());
            media.setDescription(mediaDTO.getDescription());
            media.setPhotoUrl(mediaDTO.getPhotoUrl());
            media.setReleaseDate(mediaDTO.getReleaseDate());
            Media updatedMedia = mediaRepository.save(media);
            return MediaMapper.toDTO(updatedMedia);
        }
        return null;
    }

    @Override
    public void deleteMedia(Integer id) {
        mediaRepository.deleteById(id);
    }
}
