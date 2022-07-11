package com.management.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.management.demo.entities.Product;
import com.management.demo.entities.User;
import com.management.demo.service.ProductService;
import com.management.demo.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
    @Autowired
    UserService userService;	
    
    private List<User> getAllProduct(){
    	return userService.getAllUser();
    }
    
    private User getUser(@PathVariable("idUser")long IdUser) {
    	return userService.getUserById(IdUser);
    }
    private void deleteUserById(@PathVariable ("Userid") long IdUser) {
    	userService.deleteUser(IdUser);
    }
    
	private ResponseEntity saveProduct(@RequestBody User user) {
		User saveProduct = userService.saveUser(user);
		return new ResponseEntity<>(saveProduct, HttpStatus.OK);
	}
    
    
    private User update(@RequestBody User user ,long IdUser ) {
    	userService.updateUser(user ,IdUser);
    	return user;
    }

}
