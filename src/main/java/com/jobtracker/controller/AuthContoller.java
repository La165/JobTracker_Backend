package com.jobtracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.entity.User;
import com.jobtracker.security.JwtUtil;
import com.jobtracker.service.UserService;

@RestController
@RequestMapping("/auth")

public class AuthContoller {
	
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		return userService.registerUser(user);
	}
    
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {

	    Optional<User> existingUser = userService.findByEmail(user.getEmail());

	    if (existingUser.isPresent()) {

	        User dbuser = existingUser.get();

	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	        if (encoder.matches(user.getPassword(), dbuser.getPassword())) {
	            return jwtUtil.generateToken(user.getEmail());
	        }
	    }

	    return "invalid credentials";
	}
	
}
