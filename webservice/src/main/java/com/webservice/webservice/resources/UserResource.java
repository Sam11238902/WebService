package com.webservice.webservice.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservice.webservice.entities.User;
import com.webservice.webservice.service.UserService;


@RestController

@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//METODO GET PARA RECUPERAR DADOS
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
	
	
	// PARA INSERIR DADOS.
	/*
	 * 
	 * 
	 * 
	 */
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		
		obj = service.insert(obj);	
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		
		
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		service.delete(id);
		
		return ResponseEntity.noContent().build();
		
		
	}
	
	


}

