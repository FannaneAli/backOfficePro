package com.example.backofficepro.repository;

import com.example.backofficepro.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    // Filtrer les news par titre
    List<News> findByTitleContainingIgnoreCase(String title);

    // Filtrer les news par catégorie
    List<News> findByCategoryContainingIgnoreCase(String category);

    // Filtrer les news par auteur
    List<News> findByAuthorContainingIgnoreCase(String author);

    // Filtrer les news par acteur
    List<News> findByActorsNameContainingIgnoreCase(String actorName);
}
