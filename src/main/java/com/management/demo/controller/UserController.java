package com.management.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.demo.entities.Product;
import com.management.demo.entities.User;
import com.management.demo.service.ProductService;
import com.management.demo.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
	
    @Autowired
    UserService userService;	
    
    @GetMapping("/getAllUser")
    private List<User> getAllProduct(){
    	return userService.getAllUser();
    }
    
    @GetMapping("/findUser/{idUser}")
    private User getUser(@PathVariable("idUser")long IdUser) {
    	return userService.getUserById(IdUser);
    }
    
    @DeleteMapping("/deleteUser/{Userid}")
    private void deleteUserById(@PathVariable ("Userid") long IdUser) {
    	userService.deleteUser(IdUser);
    }
    
    @PostMapping("/addUser")
	private ResponseEntity AddUser(@RequestBody User user) {
		User saveProduct = userService.saveUser(user);
		return new ResponseEntity<>(saveProduct, HttpStatus.OK);
	}
    
    @PutMapping("/updateUser")
    private User update(@RequestBody User user ,long IdUser ) {
    	userService.updateUser(user ,IdUser);
    	return user;
    }

}
