package com.example.helpify.repository;

import com.example.helpify.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  UserRepository extends JpaRepository<User,Long>{

    public User findUserByEmail(String email);
    public Boolean existsByEmail(String email);

}

