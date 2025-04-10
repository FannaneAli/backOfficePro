package com.example.backofficepro.service;

import com.example.backofficepro.dto.MediaNewsAssociationDTO;

import java.util.List;

public interface IMediaNewsAssociationService {

    MediaNewsAssociationDTO getMediaNewsAssociationById(Long id);

    List<MediaNewsAssociationDTO> getAllMediaNewsAssociations();

    MediaNewsAssociationDTO createMediaNewsAssociation(MediaNewsAssociationDTO mediaNewsAssociationDTO);

    MediaNewsAssociationDTO updateMediaNewsAssociation(Long id, MediaNewsAssociationDTO mediaNewsAssociationDTO);

    void deleteMediaNewsAssociation(Long id);
}
