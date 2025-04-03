package com.example.backofficepro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
@DiscriminatorValue("TVShow")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TVShow extends Media {

    @OneToMany(mappedBy = "tvShow")
    private List<Season> seasons;

}
