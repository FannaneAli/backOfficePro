package com.example.backofficepro.repository;

import com.example.backofficepro.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface ThemeRepository extends JpaRepository<Theme, Long> {
    //List<Theme> findByNameContainingIgnoreCase(String name);
}
