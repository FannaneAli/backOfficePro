package com.example.backofficepro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaDTO {

    private Integer id;
    private String title;
    private Integer rating;
    private String description;
    private String photoUrl;
    private String releaseDate;
}
