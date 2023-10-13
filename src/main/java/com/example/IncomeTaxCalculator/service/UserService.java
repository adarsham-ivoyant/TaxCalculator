package com.example.IncomeTaxCalculator.service;

import com.example.IncomeTaxCalculator.entity.User;

import java.util.List;

public interface UserService {

    public User register(User user);
    public List<User> getAllUser();
}
