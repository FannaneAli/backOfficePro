package com.example.backofficepro.repository;

import com.example.backofficepro.model.Episode;
import com.example.backofficepro.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
    //List<Season> findBySeasonNumber(Integer seasonNumber);
}
