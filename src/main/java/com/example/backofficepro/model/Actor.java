package com.example.backofficepro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;  // Importer JsonBackReference
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String biography;
    private String photoUrl;

    @ManyToMany
    @JoinTable(
            name = "actor_news", // Table de jointure entre Actor et News
            joinColumns = @JoinColumn(name = "actor_id"), // Clé étrangère pour l'Actor
            inverseJoinColumns = @JoinColumn(name = "news_id")) // Clé étrangère pour News
    private List<News> news;

    // Ajout de @JsonBackReference pour éviter la boucle infinie dans la sérialisation JSON
    @ManyToMany
    @JoinTable(
            name = "media_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id"))
    @JsonBackReference // Cette annotation empêche la sérialisation des médias dans Actor
    private List<Media> cast;
}
