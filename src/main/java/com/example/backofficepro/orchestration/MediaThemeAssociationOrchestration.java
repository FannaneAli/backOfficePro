package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.MediaThemeAssociationDTO;
import com.example.backofficepro.service.IMediaThemeAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MediaThemeAssociationOrchestration {

    @Autowired
    private IMediaThemeAssociationService mediaThemeAssociationService;

    public MediaThemeAssociationDTO getMediaThemeAssociationById(Long id) {
        return mediaThemeAssociationService.getMediaThemeAssociationById(id);
    }

    public List<MediaThemeAssociationDTO> getAllMediaThemeAssociations() {
        return mediaThemeAssociationService.getAllMediaThemeAssociations();
    }

    public MediaThemeAssociationDTO createMediaThemeAssociation(MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        return mediaThemeAssociationService.createMediaThemeAssociation(mediaThemeAssociationDTO);
    }

    public MediaThemeAssociationDTO updateMediaThemeAssociation(Long id, MediaThemeAssociationDTO mediaThemeAssociationDTO) {
        return mediaThemeAssociationService.updateMediaThemeAssociation(id, mediaThemeAssociationDTO);
    }

    public void deleteMediaThemeAssociation(Long id) {
        mediaThemeAssociationService.deleteMediaThemeAssociation(id);
    }
}
