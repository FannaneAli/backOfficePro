package com.example.backofficepro.service;

import com.example.backofficepro.dto.TVShowDTO;

import java.util.List;

public interface ITVShowService {

    TVShowDTO getTVShowById(Long id);

    List<TVShowDTO> getTVShowsByTitle(String title);

    TVShowDTO createTVShow(TVShowDTO tvShowDTO);

    TVShowDTO updateTVShow(Long id, TVShowDTO tvShowDTO);

    void deleteTVShow(Long id);
}
