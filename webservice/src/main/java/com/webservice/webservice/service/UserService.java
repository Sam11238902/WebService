package com.webservice.webservice.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webservice.webservice.entities.User;
import com.webservice.webservice.repositories.UserRepository;
import com.webservice.webservice.service.exceptions.DataBaseException;
import com.webservice.webservice.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
	
		
		return userRepository.findAll();
	}
	
	
	public User findById(Long id) {
		
		Optional<User> obj = userRepository.findById(id);
		
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	
	public User insert(User obj) {
		
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		
		
		try {
			
			if(userRepository.existsById(id)) {
				userRepository.deleteById(id);
			}
			else {
				throw new ResourceNotFoundException(id);
			}	
			
		} catch (DataIntegrityViolationException e ) {
				
			throw new DataBaseException(e.getMessage());
			
		}		
			
		}
		
		

	
	
	
	public User update(Long id, User obj) {
		
		
		// isso é melhor do que usar o findById , porque ele deixa o objeto monitorado , ele nao vai ate o banco .
		
		
		try {
		User entity = userRepository.getReferenceById(id);
		updateData(entity,obj);
		return userRepository.save(entity);
			
		} catch (EntityNotFoundException e) {
		
			throw new ResourceNotFoundException(id);
		}
	
		
		
	}


	private void updateData(User entity, User obj) {
		
		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	
	}
	
	public boolean existsById(Long id) {
	    return userRepository.existsById(id);
	}
	
	
	
}
