package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.ActorDTO;
import com.example.backofficepro.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorOrchestration {

    @Autowired
    private IActorService actorService;

    public ActorDTO getActorById(Long id) {
        return actorService.getActorById(id);
    }

    public List<ActorDTO> getActorsByName(String name) {
        return actorService.getActorsByName(name);
    }

    public ActorDTO createActor(ActorDTO actorDTO) {
        return actorService.createActor(actorDTO);
    }

    public ActorDTO updateActor(Long id, ActorDTO actorDTO) {
        return actorService.updateActor(id, actorDTO);
    }

    public void deleteActor(Long id) {
        actorService.deleteActor(id);
    }
}
