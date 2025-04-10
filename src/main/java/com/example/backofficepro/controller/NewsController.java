package com.example.backofficepro.controller;

import com.example.backofficepro.dto.NewsDTO;
import com.example.backofficepro.orchestration.NewsOrchestration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsOrchestration newsOrchestration;

    // Récupérer une actualité par ID
    @GetMapping("/{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable Integer id) {
        NewsDTO newsDTO = newsOrchestration.getNewsById(id);
        if (newsDTO != null) {
            return new ResponseEntity<>(newsDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Récupérer toutes les actualités
    @GetMapping
    public List<NewsDTO> getAllNews() {
        return newsOrchestration.getAllNews();
    }

    // Créer une nouvelle actualité
    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTO newsDTO) {
        NewsDTO createdNews = newsOrchestration.createNews(newsDTO);
        return new ResponseEntity<>(createdNews, HttpStatus.CREATED);
    }

    // Mettre à jour une actualité
    @PutMapping("/{id}")
    public ResponseEntity<NewsDTO> updateNews(@PathVariable Integer id, @RequestBody NewsDTO newsDTO) {
        NewsDTO updatedNews = newsOrchestration.updateNews(id, newsDTO);
        if (updatedNews != null) {
            return new ResponseEntity<>(updatedNews, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Supprimer une actualité
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Integer id) {
        newsOrchestration.deleteNews(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
