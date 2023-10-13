package com.example.IncomeTaxCalculator.repository;

import com.example.IncomeTaxCalculator.entity.UserIncome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIncomeRepo extends JpaRepository<UserIncome, Integer> {

    UserIncome findByPan(String pan);
}
