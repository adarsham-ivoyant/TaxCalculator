package com.example.IncomeTaxCalculator.repository;

import com.example.IncomeTaxCalculator.entity.User;
import com.example.IncomeTaxCalculator.entity.UserDeduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDeductionRepo extends JpaRepository<UserDeduction,Integer> {
    UserDeduction findByPan(String pan);
}
