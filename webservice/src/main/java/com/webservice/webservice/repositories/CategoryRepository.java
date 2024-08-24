package com.webservice.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.webservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
