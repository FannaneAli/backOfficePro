package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.NewsDTO;
import com.example.backofficepro.model.News;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper pour les entités d'actualités.
 *
 * <p>Effectue la transformation entre :
 * <ul>
 *   <li>L'entité {@link News}</li>
 *   <li>Le DTO {@link NewsDTO}</li>
 * </ul>
 *
 * @mapping Inclut les relations avec les catégories et auteurs
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface NewsMapper {

    @Mapping(target = "id", source = "news.id")
    @Mapping(target = "title", source = "news.title")
    @Mapping(target = "content", source = "news.content")
    @Mapping(target = "publishDate", source = "news.publishDate")
    @Mapping(target = "category", source = "news.category")
    @Mapping(target = "author", source = "news.author")
    NewsDTO toDTO(News news);

    @Mapping(target = "id", source = "newsDTO.id")
    @Mapping(target = "title", source = "newsDTO.title")
    @Mapping(target = "content", source = "newsDTO.content")
    @Mapping(target = "publishDate", source = "newsDTO.publishDate")
    @Mapping(target = "category", source = "newsDTO.category")
    @Mapping(target = "author", source = "newsDTO.author")
    News toEntity(NewsDTO newsDTO);

    List<NewsDTO> toDTOList(List<News> newsList);
}
