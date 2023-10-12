package com.example.IncomeTaxCalculator.repository;

import com.example.IncomeTaxCalculator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByPan(String pan);
}
