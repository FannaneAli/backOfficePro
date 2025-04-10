package com.example.backofficepro.orchestration;

import com.example.backofficepro.dto.ActorNewsAssociationDTO;
import com.example.backofficepro.service.IActorNewsAssociationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActorNewsAssociationOrchestration {

    @Autowired
    private IActorNewsAssociationService actorNewsAssociationService;

    public ActorNewsAssociationDTO getActorNewsAssociationById(Long id) {
        return actorNewsAssociationService.getActorNewsAssociationById(id);
    }

    public List<ActorNewsAssociationDTO> getAllActorNewsAssociations() {
        return actorNewsAssociationService.getAllActorNewsAssociations();
    }

    public ActorNewsAssociationDTO createActorNewsAssociation(ActorNewsAssociationDTO actorNewsAssociationDTO) {
        return actorNewsAssociationService.createActorNewsAssociation(actorNewsAssociationDTO);
    }

    public ActorNewsAssociationDTO updateActorNewsAssociation(Long id, ActorNewsAssociationDTO actorNewsAssociationDTO) {
        return actorNewsAssociationService.updateActorNewsAssociation(id, actorNewsAssociationDTO);
    }

    public void deleteActorNewsAssociation(Long id) {
        actorNewsAssociationService.deleteActorNewsAssociation(id);
    }
}
