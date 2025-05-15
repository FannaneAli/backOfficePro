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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "category")  // Le mappedBy fait référence à 'category' dans Media (TVShow, TVMovie)
    private List<Media> mediaList;  // Changez ici en List<Media>

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
