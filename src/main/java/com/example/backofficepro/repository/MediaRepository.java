package com.example.backofficepro.repository;

import com.example.backofficepro.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {


//    // Rechercher un média par titre
//    List<Media> findByTitleContainingIgnoreCase(String title);
//
//    // Rechercher un média par catégorie
//    List<Media> findByCategory_NameContainingIgnoreCase(String categoryName);
//
//    // Recherche par type de média (TVShow ou TVMovie) via la colonne 'media_type' dans la table 'media'
//    @Query("SELECT m FROM Media m WHERE TYPE(m) = :mediaType")
//    List<Media> findByMediaType(String mediaType);  // mediaType peut être "TVShow" ou "TVMovie"
//
////    @Query("SELECT m FROM Media m WHERE m.title LIKE %:title%")
////    List<Media> findByTitleContaining(@Param("title") String title);

}
