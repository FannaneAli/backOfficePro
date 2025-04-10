package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.service.ITVShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TVShowOrchestration {

    @Autowired
    private ITVShowService tvShowService;

    public TVShowDTO getTVShowById(Long id) {
        return tvShowService.getTVShowById(id);
    }

    public List<TVShowDTO> getTVShowsByTitle(String title) {
        return tvShowService.getTVShowsByTitle(title);
    }

    public TVShowDTO createTVShow(TVShowDTO tvShowDTO) {
        return tvShowService.createTVShow(tvShowDTO);
    }

    public TVShowDTO updateTVShow(Long id, TVShowDTO tvShowDTO) {
        return tvShowService.updateTVShow(id, tvShowDTO);
    }

    public void deleteTVShow(Long id) {
        tvShowService.deleteTVShow(id);
    }
}
