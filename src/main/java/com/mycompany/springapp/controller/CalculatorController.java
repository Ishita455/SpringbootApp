package com.mycompany.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/welcome")
    public String dummy(){
        return "Welcome to Springboot";
    }
}
