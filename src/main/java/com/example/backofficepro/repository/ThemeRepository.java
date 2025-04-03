package com.example.backofficepro.repository;

import com.example.backofficepro.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    List<Theme> findByNameContainingIgnoreCase(String name);
}
