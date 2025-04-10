package com.example.backofficepro.repository;

import com.example.backofficepro.model.MediaNewsAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaNewsAssociationRepository extends JpaRepository<MediaNewsAssociation, Long> {

    // List<MediaNewsAssociation> findByMediaId(Long mediaId);
}
