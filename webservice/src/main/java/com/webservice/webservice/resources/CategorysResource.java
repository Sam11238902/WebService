package com.webservice.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.webservice.entities.Category;
import com.webservice.webservice.service.CategoryService;

@RestController

@RequestMapping(value = "/categorys")
public class CategorysResource {

	@Autowired
	private CategoryService service;

	// PARA FINS DE TESTES O METODO ABAIXO ;
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {

		// Category u = new Category(1L, "Samuel", "samuel@gmail.com", "85986309782",
		// "sasasa123");

		List<Category> categorys = service.findAll();

		return ResponseEntity.ok().body(categorys);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

}
