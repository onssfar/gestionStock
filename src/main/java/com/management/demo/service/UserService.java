package com.management.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.demo.entities.Product;
import com.management.demo.entities.User;
import com.management.demo.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
     UserRepository userRepository;
    
    public List<User> getAllUser(){
    	return userRepository.findAll();
    }

    public User getUserById(long IdUser) {
    	return userRepository.findById(IdUser).get();
    }
    
    public void deleteUser(long IdUser) {
    	userRepository.deleteById(IdUser);
    }
    
    public User saveUser(User user) {
    	return this.userRepository.save(user);
    }
    
    public void updateUser(User user, long IdUser) {
    	userRepository.updateProduct(user);
    }

}
