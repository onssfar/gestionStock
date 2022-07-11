package com.management.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.demo.entities.User;
import com.management.demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product save (Product product);
	

}
