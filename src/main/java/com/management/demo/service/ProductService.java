package com.management.demo.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.demo.entities.Product;
import com.management.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return this.productRepository.findAll();
	}

	public Product getProductById(long IdProduct) {
		return this.productRepository.findById(IdProduct).get();
	}

	public void deleteProduct(long IdProduct) {
		this.productRepository.deleteById(IdProduct);
	}

	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

	public List<Product> findProductByProductName(String productName) {
		return this.productRepository.findProductProductName(productName);
	}
	
	public List<Product> findExpirationProducts(){
		return this.productRepository.findAll().stream()
				.filter(product -> TimeUnit.DAYS.convert(Math.abs(product.getExpirationDate().getTime() - new Date().getTime()), TimeUnit.MILLISECONDS) <= 14)
				.toList();
	}
}
