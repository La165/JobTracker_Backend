package com.jobtracker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // ✅ IMPORTANT IMPORT
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.jobtracker.entity.User;
import com.jobtracker.security.JwtUtil;
import com.jobtracker.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // ✅ temporary fix for CORS
public class AuthContoller {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        Optional<User> existingUser = userService.findByEmail(user.getEmail());

        if (existingUser.isPresent()) {

            User dbuser = existingUser.get();

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(user.getPassword(), dbuser.getPassword())) {
                String token = jwtUtil.generateToken(user.getEmail());
                return ResponseEntity.ok(token);
            }
        }

        return ResponseEntity.badRequest().body("Invalid credentials");
    }
}