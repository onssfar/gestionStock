package com.management.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.demo.entities.User;
import com.management.demo.entities.product;

@Repository
public interface ProductRepository extends JpaRepository<product, Long>{

}
