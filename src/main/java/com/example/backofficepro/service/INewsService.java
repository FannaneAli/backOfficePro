package com.example.backofficepro.service;

import com.example.backofficepro.dto.NewsDTO;

import java.util.List;

public interface INewsService {


    NewsDTO getNewsById(Long id);

    List<NewsDTO> getNewsByTitle(String title);

    NewsDTO createNews(NewsDTO newsDTO);

    List<NewsDTO> getAllNews();

    NewsDTO updateNews(Long id, NewsDTO newsDTO);

    void deleteNews(Long id);
}
