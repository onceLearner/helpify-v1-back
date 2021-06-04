package com.example.helpify.controller;

import com.example.helpify.model.Admin;
import com.example.helpify.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class GestionAdmin {

    @Autowired
    AdminRepository adminRepository;


    @GetMapping("admin/admins")
    private List<Admin> getAllAdmins () {
        return adminRepository.findAll();
    }

    @PostMapping("/admin/add")
    private Boolean addAdmin (@RequestBody Admin admin){
        adminRepository.save(admin);
        return true;
    }

    @GetMapping("/admin/login?useranme={username}&password={password}")
    private Admin loginAdmin(@RequestParam (name = "username") String username,@RequestParam(name = "password") String password  ) {


        Admin foundAdmin=null;

        foundAdmin=adminRepository.findAdminByUsernameAAndPassword(username,password);
        return  foundAdmin;


    }
}
