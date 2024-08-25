package com.webservice.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.webservice.entities.Product;
import com.webservice.webservice.service.ProductService;

@RestController			

@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService service;

	// PARA FINS DE TESTES O METODO ABAIXO ;
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {

		// Product u = new Product(1L, "Samuel", "samuel@gmail.com", "85986309782",
		// "sasasa123");

		List<Product> Products = service.findAll();

		return ResponseEntity.ok().body(Products);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
