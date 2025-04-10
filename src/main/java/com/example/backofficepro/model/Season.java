package com.example.backofficepro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer releaseDate;  // Release date as Integer, assuming it refers to a year or a date as an integer
    private String trailerUrl;    // URL for the trailer
    private String photoUrl;      // URL for the photo
    private Integer seasonNumber;

    @ManyToOne
    @JoinColumn(name = "tv_show_id")
    private TVShow tvShow;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;

    public Season(Integer id, Integer releaseDate, String trailerUrl, String photoUrl, Integer seasonNumber, TVShow entity) {
        this.id = id;
        this.releaseDate = releaseDate;
        this.trailerUrl = trailerUrl;
        this.photoUrl = photoUrl;
        this.seasonNumber = seasonNumber;
        this.tvShow = entity;

    }
}
