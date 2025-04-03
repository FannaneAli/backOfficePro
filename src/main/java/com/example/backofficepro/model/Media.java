package com.example.backofficepro.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;  // Importer JsonManagedReference
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "media_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "media_theme",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id"))
    private List<Theme> themes;

    private Integer rating;
    private String description;
    private String photoUrl;
    private String releaseDate;

    // Ajout de @JsonManagedReference pour gérer la sérialisation dans Media
    @ManyToMany
    @JoinTable(
            name = "media_actor",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @JsonManagedReference // Cette annotation gère la sérialisation des acteurs dans Media
    private List<Actor> cast;

    private String director;
    private String productionCompany;
    private String categoryAge;
    private String language;

    @ManyToMany
    @JoinTable(
            name = "media_related_media",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "related_media_id"))
    @JsonManagedReference // Sérialisation gérée pour les médias similaires
    private List<Media> relatedMedia;

    @ManyToMany
    @JoinTable(
            name = "media_news",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "news_id"))
    private List<News> news;
}
