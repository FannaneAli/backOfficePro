package com.example.backofficepro.controller;

import com.example.backofficepro.model.News;
import com.example.backofficepro.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news") // Base URL for all news-related endpoints
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // Endpoint pour ajouter une nouvelle news
    @PostMapping
    public ResponseEntity<News> addNews(@RequestBody News news) {
        News savedNews = newsService.addNews(news);
        return new ResponseEntity<>(savedNews, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour une news existante
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Integer id, @RequestBody News news) {
        news.setId(id); // Mettre à jour l'ID de la news
        News updatedNews = newsService.updateNews(news);
        if (updatedNews != null) {
            return new ResponseEntity<>(updatedNews, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Si la news n'existe pas
        }
    }

    // Endpoint pour supprimer une news
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Integer id) {
        newsService.deleteNews(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retourne un code HTTP 204 (No Content)
    }

    // Endpoint pour obtenir une news par son ID
    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Integer id) {
        Optional<News> news = newsService.getNewsById(id);
        return news.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour rechercher des news par titre
    @GetMapping("/search/title")
    public ResponseEntity<List<News>> searchNewsByTitle(@RequestParam String title) {
        List<News> newsList = newsService.searchNewsByTitle(title);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    // Endpoint pour rechercher des news par catégorie
    @GetMapping("/search/category")
    public ResponseEntity<List<News>> searchNewsByCategory(@RequestParam String category) {
        List<News> newsList = newsService.searchNewsByCategory(category);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    // Endpoint pour rechercher des news par auteur
    @GetMapping("/search/author")
    public ResponseEntity<List<News>> searchNewsByAuthor(@RequestParam String author) {
        List<News> newsList = newsService.searchNewsByAuthor(author);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    // Endpoint pour rechercher des news par acteur
    @GetMapping("/search/actor")
    public ResponseEntity<List<News>> searchNewsByActor(@RequestParam String actorName) {
        List<News> newsList = newsService.searchNewsByActor(actorName);
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    // Endpoint pour obtenir toutes les news
    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        List<News> newsList = newsService.getAllNews();
        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }
}
