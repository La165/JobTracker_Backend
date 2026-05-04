package com.jobtracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.entity.User;
import com.jobtracker.service.UserService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		return userService.registerUser(user);
	}
	
	@GetMapping("/email")
	public Optional<User> getUserByEmail(@RequestParam String email)
	{
		return userService.findByEmail(email);
	}
}


