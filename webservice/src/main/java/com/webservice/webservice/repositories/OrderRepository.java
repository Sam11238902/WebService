package com.webservice.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.webservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
