package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.MediaActorAssociationDTO;
import com.example.backofficepro.service.IMediaActorAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MediaActorAssociationOrchestration {

    @Autowired
    private IMediaActorAssociationService mediaActorAssociationService;

    public MediaActorAssociationDTO getMediaActorAssociationById(Long id) {
        return mediaActorAssociationService.getMediaActorAssociationById(id);
    }

    public List<MediaActorAssociationDTO> getAllMediaActorAssociations() {
        return mediaActorAssociationService.getAllMediaActorAssociations();
    }

    public MediaActorAssociationDTO createMediaActorAssociation(MediaActorAssociationDTO mediaActorAssociationDTO) {
        return mediaActorAssociationService.createMediaActorAssociation(mediaActorAssociationDTO);
    }

    public MediaActorAssociationDTO updateMediaActorAssociation(Long id, MediaActorAssociationDTO mediaActorAssociationDTO) {
        return mediaActorAssociationService.updateMediaActorAssociation(id, mediaActorAssociationDTO);
    }

    public void deleteMediaActorAssociation(Long id) {
        mediaActorAssociationService.deleteMediaActorAssociation(id);
    }
}
