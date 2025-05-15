package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.ActorDTO;
import com.example.backofficepro.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Builder;
import java.util.List;

/**
 * Mapper MapStruct pour la conversion entre les entités Actor et ActorDTO.
 *
 * <p>Gère le mapping bidirectionnel entre :
 * <ul>
 *   <li>L'entité de persistance {@link Actor}</li>
 *   <li>Le DTO de transfert {@link ActorDTO}</li>
 * </ul>
 *
 * @config Configuration MapStruct avec le modèle Spring
 */


@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ActorMapper {

    @Mapping(target = "id", source = "actor.id")
    @Mapping(target = "name", source = "actor.name")
    @Mapping(target = "biography", source = "actor.biography")
    @Mapping(target = "photoUrl", source = "actor.photoUrl")
    ActorDTO toDTO(Actor actor);

    @Mapping(target = "id", source = "actorDTO.id")
    @Mapping(target = "name", source = "actorDTO.name")
    @Mapping(target = "biography", source = "actorDTO.biography")
    @Mapping(target = "photoUrl", source = "actorDTO.photoUrl")
    Actor toEntity(ActorDTO actorDTO);

    List<ActorDTO> toDTOList(List<Actor> actors);
}
