package com.example.backofficepro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDate publishDate;
    private String category;
    private String author;

    @OneToMany(mappedBy = "news")
    private List<ActorNewsAssociation> actorAssociations;  // Updated to association class

    @OneToMany(mappedBy = "news")
    private List<MediaNewsAssociation> mediaAssociations;  // Updated to association class

    public News(Long id, String title, String content, LocalDate publishDate, String category, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
        this.category = category;
        this.author = author;

    }
}
