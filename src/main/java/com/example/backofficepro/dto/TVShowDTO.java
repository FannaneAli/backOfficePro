package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TVShowDTO {
    private Long id;
    private String title;
    private Integer rating;
    private String description;
    private String photoUrl;
    private String releaseDate;

    private String director;
    private String productionCompany;
    private String categoryAge;
    private String language;
    private Long categoryId;
    private String categoryName;
    private List<EpisodeDTO> episodes;

}
