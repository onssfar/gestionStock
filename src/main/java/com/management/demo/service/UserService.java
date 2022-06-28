package com.management.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.demo.repository.UserRepository;

@Service
public class UserService {
	
    @Autowired
     UserRepository userRepository;

}
