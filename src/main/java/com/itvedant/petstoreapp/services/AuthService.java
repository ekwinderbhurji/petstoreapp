package com.itvedant.petstoreapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.itvedant.petstoreapp.entities.RegisteredUser;
import com.itvedant.petstoreapp.repositories.RegisteredUserRepository;

@Service
public class AuthService {
    
    @Autowired
    private RegisteredUserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public String register(RegisteredUser user){
        //we don't want to save textual password
        //so we will first encode it and then save it
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        //here save will insert the record in database
        this.repository.save(user);
        return "User Registered Successfully";
    }
}
