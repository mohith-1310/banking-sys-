package com.coding.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.banking.model.User;
import com.coding.banking.repository.UserRepository;

@Service
public class UserService {
@Autowired
private UserRepository userRepository;
	public User insert(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

}
