package com.example.backofficepro.service;

import com.example.backofficepro.dto.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {

    EpisodeDTO getEpisodeById(Long id);

    List<EpisodeDTO> getAllEpisodes();

    EpisodeDTO createEpisode(EpisodeDTO episodeDTO);

    EpisodeDTO updateEpisode(Long id, EpisodeDTO episodeDTO);

    void deleteEpisode(Long id);
}
