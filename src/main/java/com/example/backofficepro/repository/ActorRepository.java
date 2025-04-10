package com.example.backofficepro.repository;

import com.example.backofficepro.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ActorRepository extends JpaRepository<Actor, Long> {
    //Optional<Actor> findByName(String name);
}
