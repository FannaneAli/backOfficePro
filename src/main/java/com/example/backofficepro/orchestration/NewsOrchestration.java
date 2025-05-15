package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.NewsDTO;
import com.example.backofficepro.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Orchestrateur du système d'actualités.
 * Coordonne :
 * - Le cycle de vie des articles d'actualité
 * - Les relations avec les autres entités
 * - Les stratégies de publication multi-canaux
 */


@Component
public class NewsOrchestration {

    @Autowired
    private INewsService newsService;

    public NewsDTO getNewsById(Long id) {
        return newsService.getNewsById(id);
    }

    public List<NewsDTO> getNewsByTitle(String title) {
        return newsService.getNewsByTitle(title);
    }

    // Récupérer toutes les actualités
    public List<NewsDTO> getAllNews() {
        return newsService.getAllNews();  // Vous devez implémenter cette méthode dans INewsService
    }

    public NewsDTO createNews(NewsDTO newsDTO) {
        return newsService.createNews(newsDTO);
    }

    public NewsDTO updateNews(Long id, NewsDTO newsDTO) {
        return newsService.updateNews(id, newsDTO);
    }

    public void deleteNews(Long id) {
        newsService.deleteNews(id);
    }
}
