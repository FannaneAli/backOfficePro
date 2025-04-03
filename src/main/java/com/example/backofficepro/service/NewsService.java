package com.example.backofficepro.service;

import com.example.backofficepro.model.News;
import com.example.backofficepro.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    // Ajouter une nouvelle news
    public News addNews(News news) {
        return newsRepository.save(news);
    }

    // Mettre à jour une news existante
    public News updateNews(News news) {
        if (newsRepository.existsById(news.getId())) {
            return newsRepository.save(news);
        }
        return null;  // Si la news n'existe pas
    }

    // Supprimer une news
    public void deleteNews(Integer id) {
        newsRepository.deleteById(id);
    }

    // Trouver une news par son ID
    public Optional<News> getNewsById(Integer id) {
        return newsRepository.findById(id);
    }

    // Rechercher des news par titre
    public List<News> searchNewsByTitle(String title) {
        return newsRepository.findByTitleContainingIgnoreCase(title);
    }

    // Rechercher des news par catégorie
    public List<News> searchNewsByCategory(String category) {
        return newsRepository.findByCategoryContainingIgnoreCase(category);
    }

    // Rechercher des news par auteur
    public List<News> searchNewsByAuthor(String author) {
        return newsRepository.findByAuthorContainingIgnoreCase(author);
    }

    // Rechercher des news par acteur
    public List<News> searchNewsByActor(String actorName) {
        return newsRepository.findByActorsNameContainingIgnoreCase(actorName);
    }

    // Obtenir toutes les news
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
