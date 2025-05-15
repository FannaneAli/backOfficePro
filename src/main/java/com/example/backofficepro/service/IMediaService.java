package com.example.backofficepro.service;

import com.example.backofficepro.dto.MediaDTO;

import java.util.List;

public interface IMediaService {


    MediaDTO getMediaById(Long id);

    List<MediaDTO> getAllMedia();

    MediaDTO createMedia(MediaDTO mediaDTO);


    MediaDTO updateMedia(Long id, MediaDTO mediaDTO);

    void deleteMedia(Long id);
}
