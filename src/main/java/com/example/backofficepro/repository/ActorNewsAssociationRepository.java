package com.example.backofficepro.repository;

import com.example.backofficepro.model.ActorNewsAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorNewsAssociationRepository extends JpaRepository<ActorNewsAssociation, Long> {

    // List<ActorNewsAssociation> findByActorId(Long actorId);
}
