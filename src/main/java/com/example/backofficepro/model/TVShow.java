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
@DiscriminatorValue("TV_SHOW")
public class TVShow extends Media {

    @OneToMany(mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Episode> episodes;  // Relation One-to-Many avec Episode

}
