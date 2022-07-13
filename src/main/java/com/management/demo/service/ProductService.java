package com.management.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.demo.entities.Product;
import com.management.demo.entities.ROLE_USER;
import com.management.demo.entities.User;
import com.management.demo.repository.ProductRepository;

@Service
public class ProductService {

	private User user;
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

	boolean checkRole() {
		return !this.user.getRole().isEmpty()
				? this.user.getRole().stream().map(role -> role.getValue() == ROLE_USER.CONSULT.getValue()).findAny()
						.get()
				: false;
	}
}
