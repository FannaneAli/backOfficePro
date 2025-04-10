package com.example.backofficepro.service;

import com.example.backofficepro.dto.SeasonDTO;

import java.util.List;

public interface ISeasonService {



    SeasonDTO getSeasonById(Integer id);

    List<SeasonDTO> getAllSeasons();

    SeasonDTO createSeason(SeasonDTO seasonDTO);



    SeasonDTO updateSeason(Integer id, SeasonDTO seasonDTO);

    void deleteSeason(Integer id);
}
