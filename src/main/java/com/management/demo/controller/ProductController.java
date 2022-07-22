package com.management.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.management.demo.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/manageProduct")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {
		return this.productService.getAllProducts();
	}

	@GetMapping("/findProduct/{productId}")
	public Product getProductById(@PathVariable("productId") long productId) {
		return this.productService.getProductById(productId);
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public void deleteProductById(@PathVariable("productId") long productId) {
		this.productService.deleteProduct(productId);
	}

	@PostMapping("/addProduct")
	public ResponseEntity AddProduct(@RequestBody Product product) {
		Product saveProduct = this.productService.saveProduct(product);
		return saveProduct != null ? new ResponseEntity<>(saveProduct, HttpStatus.OK)
				: new ResponseEntity<>(saveProduct, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return this.productService.updateProduct(product);
	}

	@GetMapping("/searchProductByProductName")
	public List<Product> findProductsByProductName(String productName) {
		return this.productService.findProductByProductName(productName);
	}

	@GetMapping("/findExpirationProducts")
	public List<Product> findExpirationProducts() {
		return this.productService.findExpirationProducts();
	}
}
