package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.NewsDTO;
import com.example.backofficepro.model.News;
import java.util.List;
import java.util.stream.Collectors;

public class NewsMapper {

    public static NewsDTO toDTO(News news) {
        if (news == null) {
            return null;
        }
        return new NewsDTO(
                news.getId(),
                news.getTitle(),
                news.getContent(),
                news.getPublishDate(),
                news.getCategory(),
                news.getAuthor()
        );
    }

    public static News toEntity(NewsDTO newsDTO) {
        if (newsDTO == null) {
            return null;
        }
        return new News(
                newsDTO.getId(),
                newsDTO.getTitle(),
                newsDTO.getContent(),
                newsDTO.getPublishDate(),
                newsDTO.getCategory(),
                newsDTO.getAuthor()
        );
    }

    public static List<NewsDTO> toDTOList(List<News> newsList) {
        return newsList.stream()
                .map(NewsMapper::toDTO)
                .collect(Collectors.toList());
    }
}
