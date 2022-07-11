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
import com.management.demo.repository.ProductRepository;
import com.management.demo.repository.UserRepository;
import com.management.demo.service.ProductService;



@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
    @Autowired
    private ProductService productService;	
    
    @GetMapping("/getAllProduct")
    private List<Product> getAllProduct(){
    	return productService.getAllProduct();
    }
    
    @GetMapping("/findProduct/{ productid}")
    private Product getProduct(@PathVariable("productid")long IdProduct) {
    	return productService.getProductById(IdProduct);
    }
    
    @DeleteMapping("/deleteProduct/{productid}")
    private void deleteProduct(@PathVariable ("productid") long IdProduct) {
    	productService.delete(IdProduct);
    }
    
    @PostMapping("/addProduct")
	private ResponseEntity AddProduct(@RequestBody Product product) {
		Product saveProduct = productService.saveProd(product);
		return new ResponseEntity<>(saveProduct, HttpStatus.OK);
	}
    
	@PutMapping("/updateProduct")
    private Product update(@RequestBody Product product ,long IdProduct ) {
    	productService.update(product, IdProduct);
    	return product;
    }
    

}
