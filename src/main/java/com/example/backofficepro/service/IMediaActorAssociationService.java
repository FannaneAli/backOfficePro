package com.example.backofficepro.service;

import com.example.backofficepro.dto.MediaActorAssociationDTO;

import java.util.List;

public interface IMediaActorAssociationService {

    MediaActorAssociationDTO getMediaActorAssociationById(Long id);

    List<MediaActorAssociationDTO> getAllMediaActorAssociations();

    MediaActorAssociationDTO createMediaActorAssociation(MediaActorAssociationDTO mediaActorAssociationDTO);

    MediaActorAssociationDTO updateMediaActorAssociation(Long id, MediaActorAssociationDTO mediaActorAssociationDTO);

    void deleteMediaActorAssociation(Long id);
}
