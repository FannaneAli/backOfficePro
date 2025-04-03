package com.example.backofficepro.service;

import com.example.backofficepro.model.Media;
import com.example.backofficepro.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    @Autowired
    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    // Ajouter un nouveau média
    public Media addMedia(Media media) {
        return mediaRepository.save(media);
    }

    // Mettre à jour un média existant
    public Media updateMedia(Media media) {
        if (mediaRepository.existsById(media.getId())) {
            return mediaRepository.save(media);
        }
        return null;  // Si le média n'existe pas
    }

    // Supprimer un média
    public void deleteMedia(Integer id) {
        mediaRepository.deleteById(id);
    }

    // Trouver un média par son ID
    public Optional<Media> getMediaById(Integer id) {
        return mediaRepository.findById(id);
    }

    // Rechercher un média par titre
    public List<Media> searchMediaByTitle(String title) {
        return mediaRepository.findByTitleContainingIgnoreCase(title);
    }

    // Rechercher un média par catégorie
    public List<Media> searchMediaByCategory(String categoryName) {
        return mediaRepository.findByCategory_NameContainingIgnoreCase(categoryName);
    }

    // Méthode pour récupérer les médias par type (TVShow ou TVMovie)
    public List<Media> getMediaByType(String mediaType) {
        return mediaRepository.findByMediaType(mediaType);
    }

    // Obtenir tous les médias
    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }
}
