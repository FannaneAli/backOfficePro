package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TVShowDTO extends MediaDTO {
    private String director;
    private String productionCompany;
    private String categoryAge;
    private String language;
    private Long categoryId;
    private List<EpisodeDTO> episodes;

    public TVShowDTO(Long id, String title, Integer rating, String description, String photoUrl, String releaseDate,
                     String director, String productionCompany, String categoryAge, String language, Long categoryId, List<EpisodeDTO> episodes) {
        super(id, title, rating, description, photoUrl, releaseDate);
        this.director = director;
        this.productionCompany = productionCompany;
        this.categoryAge = categoryAge;
        this.language = language;
        this.categoryId = categoryId;
        this.episodes = episodes;
    }

}