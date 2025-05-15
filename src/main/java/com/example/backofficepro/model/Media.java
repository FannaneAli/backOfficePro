package com.example.backofficepro.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "media_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "media")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Media implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Changement de génération de clé primaire
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "media")
    private List<MediaThemeAssociation> themeAssociations;

    private Integer rating;
    private String description;
    private String photoUrl;
    private String releaseDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "media")
    private List<MediaActorAssociation> actorAssociations;

    private String director;
    private String productionCompany;
    private String categoryAge;
    private String language;

    @OneToMany(mappedBy = "media")
    private List<MediaNewsAssociation> newsAssociations;

    public Media(Long id, String title, Integer rating, String description, String photoUrl, String releaseDate) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.photoUrl = photoUrl;
        this.releaseDate = releaseDate;
    }
}
