package com.example.backofficepro.repository;

import com.example.backofficepro.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface NewsRepository extends JpaRepository<News, Long> {

}
