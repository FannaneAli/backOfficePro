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

    @OneToMany(mappedBy = "theme")
    private List<MediaThemeAssociation> mediaAssociations;  // Updated to association class

    public Theme(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
