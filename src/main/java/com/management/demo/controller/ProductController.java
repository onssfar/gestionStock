package com.management.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.management.demo.repository.UserRepository;
import com.management.demo.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
    @Autowired
    ProductService productService;	

}
