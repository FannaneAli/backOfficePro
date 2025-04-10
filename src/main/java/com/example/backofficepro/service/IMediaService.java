package com.example.backofficepro.service;

import com.example.backofficepro.dto.MediaDTO;

import java.util.List;

public interface IMediaService {


    MediaDTO getMediaById(Integer id);

    List<MediaDTO> getAllMedia();

    MediaDTO createMedia(MediaDTO mediaDTO);


    MediaDTO updateMedia(Integer id, MediaDTO mediaDTO);

    void deleteMedia(Integer id);
}
