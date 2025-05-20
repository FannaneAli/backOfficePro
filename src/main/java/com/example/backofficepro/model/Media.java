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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  // Utilisation de SINGLE_TABLE pour l'héritage
@DiscriminatorColumn(name = "media_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "media")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Media implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;  // ManyToOne avec Category

    @ManyToMany
    @JoinTable(
            name = "media_theme",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id")
    )
    private List<Theme> themes;  // ManyToMany avec Theme

    private Integer rating;
    private String description;
    private String photoUrl;
    private String releaseDate;

    private String director;
    private String productionCompany;
    private String categoryAge;
    private String language;

    @JsonManagedReference
    @OneToMany(mappedBy = "media")
    private List<MediaActorAssociation> actorAssociations;

    @OneToMany(mappedBy = "media")
    private List<MediaNewsAssociation> newsAssociations;
}
