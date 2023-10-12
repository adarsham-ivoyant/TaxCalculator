package com.example.IncomeTaxCalculator.controller;

import com.example.IncomeTaxCalculator.entity.User;
import com.example.IncomeTaxCalculator.service.UserService;
import com.example.IncomeTaxCalculator.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("IncomeTaxCalculator/")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public User register(@RequestBody User user){
        try{
            return userService.register(user);
        }catch (Exception e){
           logger.info(e.getMessage());
        }
        return null;
    }
}
