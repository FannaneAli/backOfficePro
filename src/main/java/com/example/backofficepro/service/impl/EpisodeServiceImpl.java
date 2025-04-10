package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.EpisodeDTO;
import com.example.backofficepro.mapper.EpisodeMapper;
import com.example.backofficepro.model.Episode;
import com.example.backofficepro.repository.EpisodeRepository;
import com.example.backofficepro.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodeServiceImpl implements IEpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Override
    public EpisodeDTO getEpisodeById(Long id) {
        Optional<Episode> episode = episodeRepository.findById(id);
        return episode.map(EpisodeMapper::toDTO).orElse(null);
    }

    @Override
    public List<EpisodeDTO> getAllEpisodes() {
        List<Episode> episodes = episodeRepository.findAll();
        return EpisodeMapper.toDTOList(episodes);
    }

    @Override
    public EpisodeDTO createEpisode(EpisodeDTO episodeDTO) {
        Episode episode = EpisodeMapper.toEntity(episodeDTO);
        Episode savedEpisode = episodeRepository.save(episode);
        return EpisodeMapper.toDTO(savedEpisode);
    }

    @Override
    public EpisodeDTO updateEpisode(Long id, EpisodeDTO episodeDTO) {
        Optional<Episode> existingEpisode = episodeRepository.findById(id);
        if (existingEpisode.isPresent()) {
            Episode episode = existingEpisode.get();
            episode.setEpisodeNumber(episodeDTO.getEpisodeNumber());
            episode.setTitle(episodeDTO.getTitle());
            episode.setDescription(episodeDTO.getDescription());
            episode.setPhotoUrl(episodeDTO.getPhotoUrl());
            episode.setDuration(episodeDTO.getDuration());
            episode.setVideoUrl(episodeDTO.getVideoUrl());
            Episode updatedEpisode = episodeRepository.save(episode);
            return EpisodeMapper.toDTO(updatedEpisode);
        }
        return null;
    }

    @Override
    public void deleteEpisode(Long id) {
        episodeRepository.deleteById(id);
    }
}
