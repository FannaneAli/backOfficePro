package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TVMovieDTO extends MediaDTO {

    private Integer duration;
    private String trailerUrl;
    private String movieUrl;
    private String part;

    public TVMovieDTO(Integer id, String title, Integer rating, String description, String photoUrl, String releaseDate, Integer duration, String trailerUrl, String movieUrl, String part) {
        super(id, title, rating, description, photoUrl, releaseDate);
        this.duration = duration;
        this.trailerUrl = trailerUrl;
        this.movieUrl = movieUrl;
        this.part = part;
    }
}
