package com.itvedant.petstoreapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.petstoreapp.entities.RegisteredUser;

public interface RegisteredUserRepository 
    extends JpaRepository<RegisteredUser, Integer>{
    
    //We will have to create a custom query method
    //to find the user by email which we are using 
    //as username here
    RegisteredUser findByEmail(String email);   
}
