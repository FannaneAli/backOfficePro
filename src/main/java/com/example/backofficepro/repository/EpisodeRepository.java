package com.example.backofficepro.repository;

import com.example.backofficepro.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EpisodeRepository extends JpaRepository<Episode, Long> {

}
