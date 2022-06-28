package com.management.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.management.demo.service.ProductService;
import com.management.demo.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
    @Autowired
    UserService userService;	

}
