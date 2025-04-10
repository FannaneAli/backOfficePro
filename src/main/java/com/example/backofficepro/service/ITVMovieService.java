package com.example.backofficepro.service;

import com.example.backofficepro.dto.TVMovieDTO;

import java.util.List;

public interface ITVMovieService {

    TVMovieDTO getTVMovieById(Long id);

    List<TVMovieDTO> getTVMoviesByTitle(String title);

    TVMovieDTO createTVMovie(TVMovieDTO tvMovieDTO);

    TVMovieDTO updateTVMovie(Long id, TVMovieDTO tvMovieDTO);

    void deleteTVMovie(Long id);
}
