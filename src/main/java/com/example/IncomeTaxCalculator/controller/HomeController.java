package com.example.IncomeTaxCalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("IncomeTaxCalculator/")
public class HomeController {

    @GetMapping
    public String welcome(){
        return "WleCome to Income Tax Calculator";
    }
}
