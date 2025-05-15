package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.CategoryDTO;
import com.example.backofficepro.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper de conversion pour les catégories multimédias.
 *
 * <p>Effectue la transformation entre :
 * <ul>
 *   <li>L'entité de domaine {@link Category}</li>
 *   <li>Sa représentation DTO {@link CategoryDTO}</li>
 * </ul>
 *
 * @mapping Conserve la structure hiérarchique des catégories
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CategoryMapper {

    @Mapping(target = "id", source = "category.id")
    @Mapping(target = "name", source = "category.name")
    @Mapping(target = "description", source = "category.description")
    CategoryDTO toDTO(Category category);

    @Mapping(target = "id", source = "categoryDTO.id")
    @Mapping(target = "name", source = "categoryDTO.name")
    @Mapping(target = "description", source = "categoryDTO.description")
    Category toEntity(CategoryDTO categoryDTO);

    List<CategoryDTO> toDTOList(List<Category> categories);
}
