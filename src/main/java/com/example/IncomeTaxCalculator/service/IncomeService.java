package com.example.IncomeTaxCalculator.service;


import com.example.IncomeTaxCalculator.entity.UserIncome;

import java.util.List;

public interface IncomeService {

    public UserIncome addIncome(UserIncome userIncome);

    public List<UserIncome> getAllUserIncome();
}
