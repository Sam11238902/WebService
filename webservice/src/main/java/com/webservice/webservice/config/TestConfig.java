package com.webservice.webservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservice.webservice.entities.User;
import com.webservice.webservice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Samuel", "samuel@gmail.com", "85986309782", "sasasa123");
		User u2 = new User(null, "Maria", "maria@gmail.com", "85986309782", "sasasa123");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
