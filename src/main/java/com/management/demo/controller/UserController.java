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

@CrossOrigin
@RestController
@RequestMapping(value = "/ManageUser")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUser")
	public List<User> getAllProduct() {
		return this.userService.getAllUsers();
	}

	@GetMapping("/findUser/{idUser}")
	public User getUser(@PathVariable("idUser") long IdUser) {
		return this.userService.getUserById(IdUser);
	}

	@DeleteMapping("/deleteUser/{Userid}")
	public void deleteUserById(@PathVariable("Userid") long IdUser) {
		this.userService.deleteUser(IdUser);
	}

	@PostMapping("/addUser")
	public ResponseEntity AddUser(@RequestBody User user) {
		User userAdded = this.userService.saveUser(user);
		return userAdded != null ? new ResponseEntity<>(userAdded, HttpStatus.OK)
				: new ResponseEntity<>(userAdded, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/updateUser")
	public User update(@RequestBody User user) {
		return this.userService.updateUser(user);
	}

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return this.userService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}
