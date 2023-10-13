package com.example.IncomeTaxCalculator.controller;

import com.example.IncomeTaxCalculator.entity.User;
import com.example.IncomeTaxCalculator.entity.UserDeduction;
import com.example.IncomeTaxCalculator.entity.UserIncome;
import com.example.IncomeTaxCalculator.repository.UserRepo;
import com.example.IncomeTaxCalculator.service.IncomeService;
import com.example.IncomeTaxCalculator.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IncomeController {

    private static final Logger logger = LoggerFactory.getLogger(IncomeController.class);

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("addUserIncome/{pan}/{secretkey}")
    public String addUserIncome(@PathVariable String pan, @PathVariable int secretkey, @RequestBody UserIncome userIncome){
        try{
            User u=userRepo.findByPan(pan);

//           System.out.println(u.getPan());
//           System.out.println(u.getSecretPin());
//           System.out.println(secretkey);
            if(u.getSecretPin()==secretkey){
                userIncome.setPan(u.getPan());
               // double temp=userIncome.getOtherIncome()+userIncome.getSalary();
                //userIncome.setSumSalary(temp);
                incomeService.addIncome(userIncome);
                return "User Income Added successfully";
            }else{
                System.out.println("Please Check the Pan Number and secret key");
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return null;
    }

    @GetMapping("GetAllUserIncome")
    public List<UserIncome> getAllUserIncome(){
        return incomeService.getAllUserIncome();
    }
}
