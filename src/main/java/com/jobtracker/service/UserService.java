package com.jobtracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobtracker.entity.User;
import com.jobtracker.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public User registerUser(User user)
	{
		if (userRepository.findByEmail(user.getEmail()).isPresent()) {
	        throw new RuntimeException("Email already exists");
	    }

		user.setRole("USER");
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
	}

	public Optional<User> findByEmail(String email)
	{
		
	return userRepository.findByEmail(email);
	}
}
