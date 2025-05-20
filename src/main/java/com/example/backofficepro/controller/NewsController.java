package com.example.backofficepro.controller;

import com.example.backofficepro.dto.NewsDTO;
import com.example.backofficepro.orchestration.NewsOrchestration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "http://localhost:4200")
public class NewsController {

    private final NewsOrchestration newsOrchestration;

    public NewsController(NewsOrchestration newsOrchestration) {
        this.newsOrchestration = newsOrchestration;
    }

    // Récupérer une actualité par ID
    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable Long id) {
        NewsDTO newsDTO = newsOrchestration.getNewsById(id);
        return newsDTO != null ? ResponseEntity.ok(newsDTO) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Récupérer toutes les actualités
    @GetMapping
    public ResponseEntity<List<NewsDTO>> getAllNews() {
        List<NewsDTO> newsList = newsOrchestration.getAllNews();
        return ResponseEntity.ok(newsList);
    }

    // Créer une nouvelle actualité
    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTO newsDTO) {
        NewsDTO createdNews = newsOrchestration.createNews(newsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
    }

    // Mettre à jour une actualité
    @PutMapping("/{id}")
    public ResponseEntity<NewsDTO> updateNews(@PathVariable Long id, @RequestBody NewsDTO newsDTO) {
        NewsDTO updatedNews = newsOrchestration.updateNews(id, newsDTO);
        return updatedNews != null ? ResponseEntity.ok(updatedNews) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Supprimer une actualité
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        newsOrchestration.deleteNews(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}