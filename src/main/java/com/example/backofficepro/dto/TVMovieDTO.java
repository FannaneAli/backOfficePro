package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TVMovieDTO extends MediaDTO {
    private Long duration;
    private String trailerUrl;
    private String movieUrl;
    private String part;
    private String director;  // ✅ Assure-toi que ce champ existe
    private String productionCompany;
    private String categoryAge;
    private String language;

    public TVMovieDTO(Long id, String title, Integer rating, String description, String photoUrl, String releaseDate,
                      Long duration, String trailerUrl, String movieUrl, String part,
                      String director, String productionCompany, String categoryAge, String language) {
        super(id, title, rating, description, photoUrl, releaseDate);
        this.duration = duration;
        this.trailerUrl = trailerUrl;
        this.movieUrl = movieUrl;
        this.part = part;
        this.director = director;  // ✅ Vérifie que cette ligne est bien présente
        this.productionCompany = productionCompany;
        this.categoryAge = categoryAge;
        this.language = language;
    }
}