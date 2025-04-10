package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDTO {

    private Integer id;
    private Integer releaseDate;
    private String trailerUrl;
    private String photoUrl;
    private Integer seasonNumber;
    private TVShowDTO tvShow;
}
