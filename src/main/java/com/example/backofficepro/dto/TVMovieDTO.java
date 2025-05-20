package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TVMovieDTO {
    private Long id;
    private String title;
    private Integer rating;
    private String description;
    private String photoUrl;
    private String releaseDate;
    private Long duration;
    private String trailerUrl;
    private String movieUrl;
    private String part;
    private String director;
    private String productionCompany;
    private String categoryAge;
    private String language;
    private Long categoryId;  // ✅ Ajout de l’ID de la catégorie
    private String categoryName;  // ✅ Ajout du nom de la catégorie
}
