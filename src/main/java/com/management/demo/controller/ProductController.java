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
import com.management.demo.repository.ProductRepository;
import com.management.demo.repository.UserRepository;
import com.management.demo.service.ProductService;



@RestController
@CrossOrigin
public class ProductController {
	
    @Autowired
    ProductService productService;	
    
    private List<Product> getAllProduct(){
    	return productService.getAllProduct();
    }
    
    private Product getProduct(@PathVariable("productid")long IdProduct) {
    	return productService.getProductById(IdProduct);
    }
    private void deleteProduct(@PathVariable ("productid") long IdProduct) {
    	productService.delete(IdProduct);
    }
    
	private ResponseEntity saveProduct(@RequestBody Product product) {
		Product saveProduct = productService.saveOrUpdate(product);
		return new ResponseEntity<>(saveProduct, HttpStatus.OK);
	}
    
    
    private Product update(@RequestBody Product product  ) {
    	productService.saveOrUpdate(product);
    	return product;
    }
    

}
