package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {

    private Integer id;
    private Integer episodeNumber;
    private String title;
    private String description;
    private String photoUrl;
    private Integer duration;
    private String videoUrl;
}
