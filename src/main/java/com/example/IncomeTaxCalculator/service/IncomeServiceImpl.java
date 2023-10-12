package com.example.IncomeTaxCalculator.service;

import com.example.IncomeTaxCalculator.entity.UserIncome;
import com.example.IncomeTaxCalculator.repository.UserIncomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Autowired
    private UserIncomeRepo userIncomeRepo;
    @Override
    public UserIncome addIncome(UserIncome userIncome) {
        return userIncomeRepo.save(userIncome);
    }
}
