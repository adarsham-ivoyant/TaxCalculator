package com.example.IncomeTaxCalculator.service;

import com.example.IncomeTaxCalculator.entity.User;
import com.example.IncomeTaxCalculator.repository.UserRepo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepo userRepo;
    @Override
    public User register(User user) {
        try{
            int temp=user.getSecretPin();
            String var=Integer.toString(temp);
            if(var.length()==6 && user.getPan().length()==10){
                return userRepo.save(user);
            }else {
                logger.info("secrete must be 6 and Pan Number should be 10");
            }
        } catch(Exception e){
            logger.info(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
