package com.webservice.webservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.webservice.entities.User;

@RestController

@RequestMapping(value ="/users")
public class UserResource {
	
	
	
	//PARA FINS DE TESTES O METODO ABAIXO ;
	@GetMapping
	public ResponseEntity<User> findAll(){
	
		User u = new User(1L, "Samuel", "samuel@gmail.com", "85986309782", "sasasa123");
		
		return ResponseEntity.ok().body(u);
		
	}

}
