package com.management.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.management.demo.entities.Product;
import com.management.demo.entities.User;
import com.management.demo.service.ProductService;
import com.management.demo.service.UserService;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	   User save(User user);
	   void updateProduct (User user);

}
