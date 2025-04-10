package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.SeasonDTO;
import com.example.backofficepro.mapper.SeasonMapper;
import com.example.backofficepro.mapper.TVShowMapper;
import com.example.backofficepro.model.Season;
import com.example.backofficepro.repository.SeasonRepository;
import com.example.backofficepro.service.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonServiceImpl implements ISeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Override
    public SeasonDTO getSeasonById(Integer id) {
        Optional<Season> season = seasonRepository.findById(id);
        return season.map(SeasonMapper::toDTO).orElse(null);
    }

    @Override
    public List<SeasonDTO> getAllSeasons() {
        List<Season> seasons = seasonRepository.findAll();
        return SeasonMapper.toDTOList(seasons);
    }

    @Override
    public SeasonDTO createSeason(SeasonDTO seasonDTO) {
        Season season = SeasonMapper.toEntity(seasonDTO);
        Season savedSeason = seasonRepository.save(season);
        return SeasonMapper.toDTO(savedSeason);
    }

    @Override
    public SeasonDTO updateSeason(Integer id, SeasonDTO seasonDTO) {
        Optional<Season> existingSeason = seasonRepository.findById(id);
        if (existingSeason.isPresent()) {
            Season season = existingSeason.get();
            season.setReleaseDate(seasonDTO.getReleaseDate());
            season.setTrailerUrl(seasonDTO.getTrailerUrl());
            season.setPhotoUrl(seasonDTO.getPhotoUrl());
            season.setSeasonNumber(seasonDTO.getSeasonNumber());
            season.setTvShow(TVShowMapper.toEntity(seasonDTO.getTvShow()));
            Season updatedSeason = seasonRepository.save(season);
            return SeasonMapper.toDTO(updatedSeason);
        }
        return null;
    }

    @Override
    public void deleteSeason(Integer id) {
        seasonRepository.deleteById(id);
    }
}
