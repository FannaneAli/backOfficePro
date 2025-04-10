package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.MediaNewsAssociationDTO;
import com.example.backofficepro.service.IMediaNewsAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MediaNewsAssociationOrchestration {

    @Autowired
    private IMediaNewsAssociationService mediaNewsAssociationService;

    public MediaNewsAssociationDTO getMediaNewsAssociationById(Long id) {
        return mediaNewsAssociationService.getMediaNewsAssociationById(id);
    }

    public List<MediaNewsAssociationDTO> getAllMediaNewsAssociations() {
        return mediaNewsAssociationService.getAllMediaNewsAssociations();
    }

    public MediaNewsAssociationDTO createMediaNewsAssociation(MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        return mediaNewsAssociationService.createMediaNewsAssociation(mediaNewsAssociationDTO);
    }

    public MediaNewsAssociationDTO updateMediaNewsAssociation(Long id, MediaNewsAssociationDTO mediaNewsAssociationDTO) {
        return mediaNewsAssociationService.updateMediaNewsAssociation(id, mediaNewsAssociationDTO);
    }

    public void deleteMediaNewsAssociation(Long id) {
        mediaNewsAssociationService.deleteMediaNewsAssociation(id);
    }
}
