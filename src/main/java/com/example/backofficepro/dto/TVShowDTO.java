package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TVShowDTO extends MediaDTO {

    private List<SeasonDTO> seasons;

    public TVShowDTO(Integer id, String title, Integer rating, String description, String photoUrl, String releaseDate, List<SeasonDTO> dtoList) {
        super(id, title, rating, description, photoUrl, releaseDate);
        this.seasons = dtoList;
    }
}
