package com.example.IncomeTaxCalculator.service;


import com.example.IncomeTaxCalculator.entity.UserDeduction;

import java.util.List;

public interface UserDeductionService {

    public UserDeduction add(UserDeduction userDeduction);

    public List<UserDeduction> getAllUserDeduction();
}
