package com.example.helpify.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiTest {

    @GetMapping("test")
    public String testapi () {
        return "hello world  ";
    }
}
