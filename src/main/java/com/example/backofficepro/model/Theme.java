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
    private Long id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "themes")  // ManyToMany inversé depuis Media
    private List<Media> mediaList;  // Liste des Médias associés à ce thème

    public Theme(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
