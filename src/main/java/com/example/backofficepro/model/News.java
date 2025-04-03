package com.example.backofficepro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;
    private LocalDate publishDate;
    private String category;
    private String author;



    @ManyToMany
    @JoinTable(
            name = "actor_news", // Table de jointure entre Actor et News
            joinColumns = @JoinColumn(name = "news_id"), // Clé étrangère pour News
            inverseJoinColumns = @JoinColumn(name = "actor_id")) // Clé étrangère pour Actor
    private List<Actor> actors;

    // Modifiez cette relation pour utiliser Media au lieu de TVShow
    @ManyToMany
    @JoinTable(
            name = "news_media",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "media_id"))
    private List<Media> relatedMedia;  // Liste de Media au lieu de TVShow
}
