package com.webservice.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.webservice.entities.Order;
import com.webservice.webservice.entities.User;
import com.webservice.webservice.service.OrderService;


@RestController
@RequestMapping(value = "/orders")

public class OrderResource {

	
	
	@Autowired
	private OrderService service;
	
	
	//PARA FINS DE TESTES O METODO ABAIXO ;
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
	
		//User u = new User(1L, "Samuel", "samuel@gmail.com", "85986309782", "sasasa123");
		
		
		List<Order> orders = service.findAll();
		
		return ResponseEntity.ok().body(orders);
		
	}
	
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
}
