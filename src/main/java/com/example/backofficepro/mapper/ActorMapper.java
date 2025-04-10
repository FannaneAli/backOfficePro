package com.example.backofficepro.mapper;

import com.example.backofficepro.dto.ActorDTO;
import com.example.backofficepro.model.Actor;
import java.util.List;
import java.util.stream.Collectors;

public class ActorMapper {

    public static ActorDTO toDTO(Actor actor) {
        if (actor == null) {
            return null;
        }
        return new ActorDTO(
                actor.getId(),
                actor.getName(),
                actor.getBiography(),
                actor.getPhotoUrl()
        );
    }
//findbyid pour recuperer les champ kamlin mais 3gzt tal ghda
    public static Actor toEntity(ActorDTO actorDTO) {
        if (actorDTO == null) {
            return null;
        }
        return new Actor(
                actorDTO.getId(),
                actorDTO.getName(),
                actorDTO.getBiography(),
                actorDTO.getPhotoUrl()
        );
    }

    public static List<ActorDTO> toDTOList(List<Actor> actors) {
        return actors.stream()
                .map(ActorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
