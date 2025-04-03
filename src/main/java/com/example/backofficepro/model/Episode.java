package com.example.backofficepro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "episode")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer episodeNumber;  // Le numéro de l'épisode
    private String title;           // Le titre de l'épisode
    private String description;     // La description de l'épisode
    private String photoUrl;        // L'URL de la photo de l'épisode
    private Integer duration;       // La durée de l'épisode
    private String videoUrl;        // L'URL de la vidéo de l'épisode

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;          // La saison à laquelle appartient cet épisode
}
