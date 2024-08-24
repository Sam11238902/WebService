package com.webservice.webservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.webservice.entities.Order;
import com.webservice.webservice.entities.User;
import com.webservice.webservice.repositories.OrderRepository;
import com.webservice.webservice.repositories.UserRepository;


@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
	
		
		return orderRepository.findAll();
	}
	
	
	public Order findById(Long id) {
		
		Optional<Order> obj = orderRepository.findById(id);
		
		return obj.get();
	}
	

}
