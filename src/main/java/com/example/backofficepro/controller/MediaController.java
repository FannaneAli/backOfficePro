package com.example.backofficepro.controller;

import com.example.backofficepro.model.Media;
import com.example.backofficepro.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/media") // Base URL for all media-related endpoints
public class MediaController {

    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    // Endpoint pour ajouter un nouveau média
    @PostMapping
    public ResponseEntity<Media> addMedia(@RequestBody Media media) {
        Media savedMedia = mediaService.addMedia(media);
        return new ResponseEntity<>(savedMedia, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un média existant
    @PutMapping("/{id}")
    public ResponseEntity<Media> updateMedia(@PathVariable Integer id, @RequestBody Media media) {
        media.setId(id); // Mettre à jour l'ID du média
        Media updatedMedia = mediaService.updateMedia(media);
        if (updatedMedia != null) {
            return new ResponseEntity<>(updatedMedia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si le média n'existe pas
        }
    }

    // Endpoint pour supprimer un média
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Integer id) {
        mediaService.deleteMedia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne un code HTTP 204 (No Content)
    }

    // Endpoint pour obtenir un média par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Media> getMediaById(@PathVariable Integer id) {
        Optional<Media> media = mediaService.getMediaById(id);
        return media.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour rechercher un média par titre
    @GetMapping("/search/title")
    public ResponseEntity<List<Media>> searchMediaByTitle(@RequestParam String title) {
        List<Media> mediaList = mediaService.searchMediaByTitle(title);
        return new ResponseEntity<>(mediaList, HttpStatus.OK);
    }

    // Endpoint pour rechercher un média par catégorie
    @GetMapping("/search/category")
    public ResponseEntity<List<Media>> searchMediaByCategory(@RequestParam String categoryName) {
        List<Media> mediaList = mediaService.searchMediaByCategory(categoryName);
        return new ResponseEntity<>(mediaList, HttpStatus.OK);
    }

    // Endpoint pour récupérer les médias par type (TVShow ou TVMovie)
    @GetMapping("/search/type")
    public ResponseEntity<List<Media>> getMediaByType(@RequestParam String mediaType) {
        List<Media> mediaList = mediaService.getMediaByType(mediaType);
        return new ResponseEntity<>(mediaList, HttpStatus.OK);
    }

    // Endpoint pour obtenir tous les médias
    @GetMapping
    public ResponseEntity<List<Media>> getAllMedia() {
        List<Media> mediaList = mediaService.getAllMedia();
        return new ResponseEntity<>(mediaList, HttpStatus.OK);
    }
}
