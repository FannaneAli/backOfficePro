package com.example.backofficepro.service.impl;

import com.example.backofficepro.dto.NewsDTO;
import com.example.backofficepro.mapper.NewsMapper;
import com.example.backofficepro.model.News;
import com.example.backofficepro.repository.NewsRepository;
import com.example.backofficepro.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Implémentation du service de gestion éditoriale.
 * Gère :
 * - Le cycle de vie complet des actualités
 * - Les relations avec les autres entités
 * - Les conversions de format éditorial
 */


@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsMapper newsMapper; // Injection du mapper

    @Override
    public NewsDTO getNewsById(Long id) {
        Optional<News> news = newsRepository.findById(id);
        return news.map(newsMapper::toDTO).orElse(null);
    }

    @Override
    public List<NewsDTO> getNewsByTitle(String title) {
        List<News> newsList = newsRepository.findAll(); // Vous pouvez ajouter une méthode personnalisée pour rechercher par titre
        return newsMapper.toDTOList(newsList);
    }

    @Override
    public NewsDTO createNews(NewsDTO newsDTO) {
        News news = newsMapper.toEntity(newsDTO);
        News savedNews = newsRepository.save(news);
        return newsMapper.toDTO(savedNews);
    }

    @Override
    public NewsDTO updateNews(Long id, NewsDTO newsDTO) {
        Optional<News> existingNews = newsRepository.findById(id);
        if (existingNews.isPresent()) {
            News news = existingNews.get();
            news.setTitle(newsDTO.getTitle());
            news.setContent(newsDTO.getContent());
            news.setPublishDate(newsDTO.getPublishDate());
            news.setCategory(newsDTO.getCategory());
            news.setAuthor(newsDTO.getAuthor());
            News updatedNews = newsRepository.save(news);
            return newsMapper.toDTO(updatedNews);
        }
        return null;
    }

    @Override
    public List<NewsDTO> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList.stream()
                .map(newsMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
