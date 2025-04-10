package com.example.backofficepro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String biography;
    private String photoUrl;

    @OneToMany(mappedBy = "actor")
    private List<ActorNewsAssociation> newsAssociations;  // Updated to association class

    @JsonBackReference
    @OneToMany(mappedBy = "actor")
    private List<MediaActorAssociation> mediaAssociations;  // Updated to association class

    public Actor(Long id, String name, String biography, String photoUrl) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.photoUrl = photoUrl;
    }
}
