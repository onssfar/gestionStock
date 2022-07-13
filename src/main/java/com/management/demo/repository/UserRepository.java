package com.management.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
