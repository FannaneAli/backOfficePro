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
@Table(name = "theme")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    // Changement de OneToMany à ManyToMany
    @ManyToMany(mappedBy = "themes")  // La relation inverse via 'themes' dans Media
    private List<Media> medias;  // Liste des médias associés à ce thème
}
