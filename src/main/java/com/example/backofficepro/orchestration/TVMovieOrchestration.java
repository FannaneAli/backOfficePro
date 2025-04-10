package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.TVMovieDTO;
import com.example.backofficepro.service.ITVMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TVMovieOrchestration {

    @Autowired
    private ITVMovieService tvMovieService;

    public TVMovieDTO getTVMovieById(Long id) {
        return tvMovieService.getTVMovieById(id);
    }

    public List<TVMovieDTO> getTVMoviesByTitle(String title) {
        return tvMovieService.getTVMoviesByTitle(title);
    }

    public TVMovieDTO createTVMovie(TVMovieDTO tvMovieDTO) {
        return tvMovieService.createTVMovie(tvMovieDTO);
    }

    public TVMovieDTO updateTVMovie(Long id, TVMovieDTO tvMovieDTO) {
        return tvMovieService.updateTVMovie(id, tvMovieDTO);
    }

    public void deleteTVMovie(Long id) {
        tvMovieService.deleteTVMovie(id);
    }
}
