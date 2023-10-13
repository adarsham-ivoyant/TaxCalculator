package com.example.IncomeTaxCalculator.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserDeduction_info")
public class UserDeduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userDeductionId;
    private double standardDeduction;
    private double hra;
    private double home_Loan;
    private double fixed_deposit;
    private double insurance;
    private String pan;




}
