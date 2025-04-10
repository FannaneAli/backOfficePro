package com.example.backofficepro.repository;

import com.example.backofficepro.model.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TVShowRepository extends JpaRepository<TVShow, Long> {
//    // Exemple de méthode personnalisée : trouver par titre contenant une chaîne
//    List<TVShow> findByTitleContaining(String title);
//
//    // Exemple de méthode personnalisée : trouver par année de sortie
//    List<TVShow> findByReleaseYear(int releaseYear);

}
