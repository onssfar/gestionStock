package com.management.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.demo.entities.Product;
import com.management.demo.repository.ProductRepository;

@Service
public class ProductService {
	
    @Autowired
    ProductRepository productRepository;
    
    public List<Product> getAllProduct(){
    	return productRepository.findAll();
    }

    public Product getProductById(long IdProduct) {
    	return productRepository.findById( IdProduct).get();
    }
    
    public void delete(long IdProduct) {
    	productRepository.deleteById(IdProduct);
    }
    
    public Product saveOrUpdate(Product product) {
    	return this.productRepository.save(product);
    }
    
    public void update(Product product, long IdProduct) {
    	productRepository.save(product);
    }
    
}
