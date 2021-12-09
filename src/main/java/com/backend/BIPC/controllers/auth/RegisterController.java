package com.backend.BIPC.controllers.auth;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.services.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String greet(){
        return "Welcome to capstone";
    }
    @PostMapping("/register")
    public User register(@Valid @RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }
}
