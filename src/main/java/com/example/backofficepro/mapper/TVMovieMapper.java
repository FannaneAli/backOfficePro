package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.TVMovieDTO;
import com.example.backofficepro.model.Category;
import com.example.backofficepro.model.TVMovie;
import org.mapstruct.Mapper;
import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import java.util.List;

/**
 * Mapper pour les films TV.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TVMovieMapper {

    @Mapping(target = "id", source = "tvMovie.id")
    @Mapping(target = "title", source = "tvMovie.title")
    @Mapping(target = "rating", source = "tvMovie.rating")
    @Mapping(target = "description", source = "tvMovie.description")
    @Mapping(target = "photoUrl", source = "tvMovie.photoUrl")
    @Mapping(target = "releaseDate", source = "tvMovie.releaseDate")
    @Mapping(target = "duration", source = "tvMovie.duration")
    @Mapping(target = "trailerUrl", source = "tvMovie.trailerUrl")
    @Mapping(target = "movieUrl", source = "tvMovie.movieUrl")
    @Mapping(target = "part", source = "tvMovie.part")
    @Mapping(target = "director", source = "tvMovie.director")
    @Mapping(target = "productionCompany", source = "tvMovie.productionCompany")
    @Mapping(target = "categoryAge", source = "tvMovie.categoryAge")
    @Mapping(target = "language", source = "tvMovie.language")
    @Mapping(target = "categoryId", source = "tvMovie.category.id")  // ✅ Ajout de l’ID de la catégorie
    @Mapping(target = "categoryName", source = "tvMovie.category.name")  // ✅ Ajout du nom de la catégorie
    TVMovieDTO toDTO(TVMovie tvMovie);

    @Mapping(target = "id", source = "tvMovieDTO.id")
    @Mapping(target = "title", source = "tvMovieDTO.title")
    @Mapping(target = "rating", source = "tvMovieDTO.rating")
    @Mapping(target = "description", source = "tvMovieDTO.description")
    @Mapping(target = "photoUrl", source = "tvMovieDTO.photoUrl")
    @Mapping(target = "releaseDate", source = "tvMovieDTO.releaseDate")
    @Mapping(target = "duration", source = "tvMovieDTO.duration")
    @Mapping(target = "trailerUrl", source = "tvMovieDTO.trailerUrl")
    @Mapping(target = "movieUrl", source = "tvMovieDTO.movieUrl")
    @Mapping(target = "part", source = "tvMovieDTO.part")
    @Mapping(target = "director", source = "tvMovieDTO.director")
    @Mapping(target = "productionCompany", source = "tvMovieDTO.productionCompany")
    @Mapping(target = "categoryAge", source = "tvMovieDTO.categoryAge")
    @Mapping(target = "language", source = "tvMovieDTO.language")
    @Mapping(target = "category", source = "tvMovieDTO.categoryId")  // ✅ Mapping vers l’entité `Category`
    TVMovie toEntity(TVMovieDTO tvMovieDTO);

    List<TVMovieDTO> toDTOList(List<TVMovie> tvMovies);

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
