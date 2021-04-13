package com.mycompany.springapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Value("${myproperty}")
    private String abcxyz;

    @GetMapping("/welcome")
    public String dummy()
    {   System.out.println(abcxyz);
        return "Welcome to Springboot";
    }
}
