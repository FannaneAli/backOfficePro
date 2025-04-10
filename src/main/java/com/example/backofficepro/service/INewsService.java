package com.example.backofficepro.service;

import com.example.backofficepro.dto.NewsDTO;

import java.util.List;

public interface INewsService {


    NewsDTO getNewsById(Integer id);

    List<NewsDTO> getNewsByTitle(String title);

    NewsDTO createNews(NewsDTO newsDTO);

    List<NewsDTO> getAllNews();

    NewsDTO updateNews(Integer id, NewsDTO newsDTO);

    void deleteNews(Integer id);
}
