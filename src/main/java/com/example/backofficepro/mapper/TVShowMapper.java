package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.TVShowDTO;
import com.example.backofficepro.model.TVShow;
import com.example.backofficepro.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TVShowMapper {

        @Mapping(target = "id", source = "tvShow.id")
        @Mapping(target = "title", source = "tvShow.title")
        @Mapping(target = "rating", source = "tvShow.rating")
        @Mapping(target = "description", source = "tvShow.description")
        @Mapping(target = "photoUrl", source = "tvShow.photoUrl")
        @Mapping(target = "releaseDate", source = "tvShow.releaseDate")
        @Mapping(target = "director", source = "tvShow.director")
        @Mapping(target = "productionCompany", source = "tvShow.productionCompany")
        @Mapping(target = "categoryAge", source = "tvShow.categoryAge")
        @Mapping(target = "language", source = "tvShow.language")
        @Mapping(target = "categoryId", source = "tvShow.category.id")
        @Mapping(target = "categoryName", source = "tvShow.category.name")  // ✅ Ajout du nom de la catégorie
        @Mapping(target = "episodes", source = "tvShow.episodes")
        TVShowDTO toDTO(TVShow tvShow);

        @Mapping(target = "id", source = "tvShowDTO.id")
        @Mapping(target = "title", source = "tvShowDTO.title")
        @Mapping(target = "rating", source = "tvShowDTO.rating")
        @Mapping(target = "description", source = "tvShowDTO.description")
        @Mapping(target = "photoUrl", source = "tvShowDTO.photoUrl")
        @Mapping(target = "releaseDate", source = "tvShowDTO.releaseDate")
        @Mapping(target = "director", source = "tvShowDTO.director")
        @Mapping(target = "productionCompany", source = "tvShowDTO.productionCompany")
        @Mapping(target = "categoryAge", source = "tvShowDTO.categoryAge")
        @Mapping(target = "language", source = "tvShowDTO.language")
        @Mapping(target = "category", source = "tvShowDTO.categoryId") // ✅ Mapping de `categoryId` vers `Category`
        @Mapping(target = "episodes", source = "tvShowDTO.episodes")
        TVShow toEntity(TVShowDTO tvShowDTO);

        List<TVShowDTO> toDTOList(List<TVShow> tvShows);

        // ✅ Custom mapping de `categoryId` vers `Category`
        default Category map(Long categoryId) {
                if (categoryId != null) {
                        Category category = new Category();
                        category.setId(categoryId);
                        return category;
                }
                return null;
        }
}
