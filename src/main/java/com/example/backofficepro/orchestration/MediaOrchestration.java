package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.MediaDTO;
import com.example.backofficepro.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MediaOrchestration {

    @Autowired
    private IMediaService mediaService;

    public MediaDTO getMediaById(Integer id) {
        return mediaService.getMediaById(id);
    }

    public List<MediaDTO> getAllMedia() {
        return mediaService.getAllMedia();
    }

    public MediaDTO createMedia(MediaDTO mediaDTO) {
        return mediaService.createMedia(mediaDTO);
    }

    public MediaDTO updateMedia(Integer id, MediaDTO mediaDTO) {
        return mediaService.updateMedia(id, mediaDTO);
    }

    public void deleteMedia(Integer id) {
        mediaService.deleteMedia(id);
    }
}
