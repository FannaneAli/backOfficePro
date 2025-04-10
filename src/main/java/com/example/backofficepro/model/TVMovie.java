package com.example.backofficepro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TVMovie")  // Indique que ce type est un "TVMovie"
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TVMovie extends Media {

    private Integer duration; // Durée spécifique à TVMovie
    private String trailerUrl;
    private String movieUrl;
    private String part;  // Partie spécifique au film (ex: Partie 1 de Harry Potter)

    public TVMovie(Integer id, String title, Integer rating, String description, String photoUrl, String releaseDate, Integer duration, String trailerUrl, String movieUrl, String part) {
        super(id, title, rating, description, photoUrl, releaseDate);
        this.duration = duration;
        this.trailerUrl = trailerUrl;
        this.movieUrl = movieUrl;
        this.part = part;
    }

    // Getters and setters omitted for brevity
}
