package com.example.backofficepro.repository;

import com.example.backofficepro.model.MediaActorAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaActorAssociationRepository extends JpaRepository<MediaActorAssociation, Long> {

    // List<MediaActorAssociation> findByActorId(Long actorId);
}
