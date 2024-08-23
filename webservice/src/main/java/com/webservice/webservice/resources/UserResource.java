package com.webservice.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.webservice.entities.User;
import com.webservice.webservice.service.UserService;

@RestController

@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	//PARA FINS DE TESTES O METODO ABAIXO ;
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
	
		//User u = new User(1L, "Samuel", "samuel@gmail.com", "85986309782", "sasasa123");
		
		
		List<User> users = service.findAll();
		
		return ResponseEntity.ok().body(users);
		
	}
	
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
