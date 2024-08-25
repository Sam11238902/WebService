package com.webservice.webservice.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.webservice.entities.User;
import com.webservice.webservice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
	
		
		return userRepository.findAll();
	}
	
	
	public User findById(Long id) {
		
		Optional<User> obj = userRepository.findById(id);
		
		return obj.get();
	}

	
	public User insert(User obj) {
		
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	
	public User update(Long id, User obj) {
		
		
		// isso é melhor do que usar o findById , porque ele deixa o objeto monitorado , ele nao vai ate o banco .
		User entity = userRepository.getReferenceById(id);
		
		
		updateData(entity,obj);
		
		
		return userRepository.save(entity);
		
	}


	private void updateData(User entity, User obj) {
		
		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
		
		
	}
	
	
	
}
