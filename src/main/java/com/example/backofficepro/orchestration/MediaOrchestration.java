package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.MediaDTO;
import com.example.backofficepro.service.IMediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Orchestrateur principal du catalogue multimédias.
 * Encapsule :
 * - La logique de gestion centralisée des médias
 * - Les interactions avec le système de stockage
 * - Les stratégies de cache et d'optimisation
 */


@Slf4j
@Component
public class MediaOrchestration {

    @Autowired
    private IMediaService mediaService;

    public MediaDTO getMediaById(Long id) {
        return mediaService.getMediaById(id);
    }

    public List<MediaDTO> getAllMedia() {
        return mediaService.getAllMedia();
    }

    public MediaDTO createMedia(MediaDTO mediaDTO) {
        return mediaService.createMedia(mediaDTO);
    }

    public MediaDTO updateMedia(Long id, MediaDTO mediaDTO) {
        return mediaService.updateMedia(id, mediaDTO);
    }

    public void deleteMedia(Long id) {
        mediaService.deleteMedia(id);
    }
}
