package com.hong.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listUsers() {
		return userRepository.findAll();
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}


}
