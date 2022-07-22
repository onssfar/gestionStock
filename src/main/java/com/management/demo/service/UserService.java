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
     private UserRepository userRepository;
    
    public List<User> getAllUsers(){
    	return this.userRepository.findAll();
    }

    public User getUserById(long IdUser) {
    	return this.userRepository.findById(IdUser).get();
    }
    
    public void deleteUser(long IdUser) {
    	this.userRepository.deleteById(IdUser);
    }
    
    public User saveUser(User user) {
    	return this.userRepository.save(user);
    }
    
    public User updateUser(User user) {
    	return this.userRepository.save(user);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
    	return this.userRepository.findUserByUsernameAndPassword(username, password);
    }
}
