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

    // Getters and setters omitted for brevity
}
