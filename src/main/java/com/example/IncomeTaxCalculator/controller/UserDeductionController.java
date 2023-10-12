package com.example.IncomeTaxCalculator.controller;

import com.example.IncomeTaxCalculator.entity.User;
import com.example.IncomeTaxCalculator.entity.UserDeduction;
import com.example.IncomeTaxCalculator.repository.UserRepo;
import com.example.IncomeTaxCalculator.service.UserDeductionService;
import com.example.IncomeTaxCalculator.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDeductionController {

    private static final Logger logger = LoggerFactory.getLogger(UserDeductionController.class);

    @Autowired
    private UserDeductionService userDeductionService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("addUserDeduction/{pan}/{secretkey}")
    public String addUserDeduction(@PathVariable String pan, @PathVariable int secretkey, @RequestBody UserDeduction userDeduction){
       try{
           User u=userRepo.findByPan(pan);

//           System.out.println(u.getPan());
//           System.out.println(u.getSecretPin());
//           System.out.println(secretkey);
           if(u.getSecretPin()==secretkey){
               userDeduction.setPan(u.getPan());
              // double temp=userDeduction.getStandardDeduction()+ userDeduction.getHra()+userDeduction.getHome_Loan()+userDeduction.getFixed_deposit()+userDeduction.getInsurance();
              // userDeduction.setSumDeductions(temp);
               userDeductionService.add(userDeduction);
               return "User Deduction Added successfully";
           }else{
              logger.info("Please Check the Pan Number and secret key");
           }
       }catch (Exception e){
           logger.info(e.getMessage());
       }
       return null;


    }
}
