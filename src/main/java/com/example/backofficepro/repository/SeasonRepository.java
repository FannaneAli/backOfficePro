package com.example.backofficepro.repository;

import com.example.backofficepro.model.Episode;
import com.example.backofficepro.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
    List<Season> findBySeasonNumber(Integer seasonNumber);


}
