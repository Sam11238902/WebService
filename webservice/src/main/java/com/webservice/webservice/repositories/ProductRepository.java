package com.webservice.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.webservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
