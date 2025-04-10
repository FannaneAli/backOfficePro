package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.SeasonDTO;
import com.example.backofficepro.service.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeasonOrchestration {

    @Autowired
    private ISeasonService seasonService;

    public SeasonDTO getSeasonById(Integer id) {
        return seasonService.getSeasonById(id);
    }

    public List<SeasonDTO> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    public SeasonDTO createSeason(SeasonDTO seasonDTO) {
        return seasonService.createSeason(seasonDTO);
    }

    public SeasonDTO updateSeason(Integer id, SeasonDTO seasonDTO) {
        return seasonService.updateSeason(id, seasonDTO);
    }

    public void deleteSeason(Integer id) {
        seasonService.deleteSeason(id);
    }
}
