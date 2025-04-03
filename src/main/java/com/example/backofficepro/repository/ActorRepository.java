package com.example.backofficepro.repository;

import com.example.backofficepro.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    // Filtrer les acteurs par leur nom
    List<Actor> findByNameContainingIgnoreCase(String name);
}
