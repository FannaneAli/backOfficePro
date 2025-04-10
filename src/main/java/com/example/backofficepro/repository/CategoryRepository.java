package com.example.backofficepro.repository;

import com.example.backofficepro.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category, Long> {

}
