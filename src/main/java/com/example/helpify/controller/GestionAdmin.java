package com.example.helpify.controller;

import com.example.helpify.model.Admin;
import com.example.helpify.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class GestionAdmin {

    @Autowired
    AdminRepository adminRepository;


    @GetMapping("/admin/admins")
    private List<Admin> getAllAdmins () {
        return adminRepository.findAll();
    }

    @PostMapping("/admin/add")
    private Boolean addAdmin (@Valid @RequestBody Admin admin){
        adminRepository.save(admin);
        return true;
    }

    @GetMapping("/admin/login")
    private Admin loginAdmin(@RequestParam (name = "username") String username,@RequestParam(name = "password") String password  ) {


        Admin foundAdmin=null;

        foundAdmin=adminRepository.findAdminByUsernameAndPassword(username,password);
        return  foundAdmin;


    }
}
