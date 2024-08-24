package com.webservice.webservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.webservice.webservice.entities.Order;
import com.webservice.webservice.entities.User;
import com.webservice.webservice.entities.enums.OrderStatus;
import com.webservice.webservice.repositories.OrderRepository;
import com.webservice.webservice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Samuel", "samuel@gmail.com", "85986309782", "sasasa123");
		User u2 = new User(null, "Maria", "maria@gmail.com", "85986309782", "sasasa123");
	
		
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID,u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),  OrderStatus.PAID, u1);
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
}
