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

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public NewsDTO getNewsById(Integer id) {
        Optional<News> news = newsRepository.findById(id);
        return news.map(NewsMapper::toDTO).orElse(null);
    }

    @Override
    public List<NewsDTO> getNewsByTitle(String title) {
        List<News> newsList = newsRepository.findAll(); // Vous pouvez ajouter une méthode personnalisée pour rechercher par titre
        return NewsMapper.toDTOList(newsList);
    }

    @Override
    public NewsDTO createNews(NewsDTO newsDTO) {
        News news = NewsMapper.toEntity(newsDTO);
        News savedNews = newsRepository.save(news);
        return NewsMapper.toDTO(savedNews);
    }

    @Override
    public NewsDTO updateNews(Integer id, NewsDTO newsDTO) {
        Optional<News> existingNews = newsRepository.findById(id);
        if (existingNews.isPresent()) {
            News news = existingNews.get();
            news.setTitle(newsDTO.getTitle());
            news.setContent(newsDTO.getContent());
            news.setPublishDate(newsDTO.getPublishDate());
            news.setCategory(newsDTO.getCategory());
            news.setAuthor(newsDTO.getAuthor());
            News updatedNews = newsRepository.save(news);
            return NewsMapper.toDTO(updatedNews);
        }
        return null;
    }

    @Override
    public List<NewsDTO> getAllNews() {
        List<News> newsList = newsRepository.findAll();
        return newsList.stream()
                .map(NewsMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteNews(Integer id) {
        newsRepository.deleteById(id);
    }
}
