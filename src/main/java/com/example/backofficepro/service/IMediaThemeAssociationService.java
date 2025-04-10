package com.example.backofficepro.service;

import com.example.backofficepro.dto.MediaThemeAssociationDTO;

import java.util.List;

public interface IMediaThemeAssociationService {

    MediaThemeAssociationDTO getMediaThemeAssociationById(Long id);

    List<MediaThemeAssociationDTO> getAllMediaThemeAssociations();

    MediaThemeAssociationDTO createMediaThemeAssociation(MediaThemeAssociationDTO mediaThemeAssociationDTO);

    MediaThemeAssociationDTO updateMediaThemeAssociation(Long id, MediaThemeAssociationDTO mediaThemeAssociationDTO);

    void deleteMediaThemeAssociation(Long id);
}
