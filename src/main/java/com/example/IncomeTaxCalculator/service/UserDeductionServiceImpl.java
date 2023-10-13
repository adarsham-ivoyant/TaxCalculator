package com.example.IncomeTaxCalculator.service;

import com.example.IncomeTaxCalculator.entity.UserDeduction;
import com.example.IncomeTaxCalculator.repository.UserDeductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDeductionServiceImpl implements UserDeductionService{

    @Autowired
    private UserDeductionRepo userDeductionRepo;
    @Override
    public UserDeduction add(UserDeduction userDeduction) {
        return userDeductionRepo.save(userDeduction);
    }

    @Override
    public List<UserDeduction> getAllUserDeduction() {
        return userDeductionRepo.findAll();
    }
}
