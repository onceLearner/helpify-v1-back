package com.example.helpify.repository;

import com.example.helpify.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    public Admin findAdminByUsernameAndPassword(String username,String password);
}
