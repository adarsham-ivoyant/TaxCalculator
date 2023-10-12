package com.example.IncomeTaxCalculator.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "UserIncome_Info")
public class UserIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userIncomeId;
    private double salary;
    private double otherIncome;
    private String pan;

}
