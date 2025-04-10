package com.example.backofficepro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "media_actor")
public class MediaActorAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "media_id")
    private Media media;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    public MediaActorAssociation(Long id, Actor entity, Media entity1) {
        this.id = id;
        this.actor = entity;
        this.media = entity1;
    }
}
