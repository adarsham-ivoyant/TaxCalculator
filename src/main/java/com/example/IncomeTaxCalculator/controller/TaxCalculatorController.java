package com.example.IncomeTaxCalculator.controller;

import com.example.IncomeTaxCalculator.entity.User;
import com.example.IncomeTaxCalculator.entity.UserDeduction;
import com.example.IncomeTaxCalculator.entity.UserIncome;
import com.example.IncomeTaxCalculator.repository.UserDeductionRepo;
import com.example.IncomeTaxCalculator.repository.UserIncomeRepo;
import com.example.IncomeTaxCalculator.repository.UserRepo;
import com.example.IncomeTaxCalculator.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxCalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(TaxCalculatorController.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserIncomeRepo userIncomeRepo;

    @Autowired
    private UserDeductionRepo userDeductionRepo;

    @GetMapping("Calculator/{pan}/{secretPin}")
    public String calculator(@PathVariable("pan") String pan, @PathVariable("secretPin") int secretPin){

        try{
            User u=userRepo.findByPan(pan);

//           System.out.println(u.getPan());
//           System.out.println(u.getSecretPin());
//           System.out.println(secretkey);
            if(u.getSecretPin()==secretPin){
                    UserIncome userIncome=userIncomeRepo.findByPan(pan);
                    double sumOfSalary=userIncome.getSalary()+userIncome.getOtherIncome();

                   UserDeduction userDeduction=userDeductionRepo.findByPan(pan);
                    double sumOfDeduction=userDeduction.getStandardDeduction()+userDeduction.getHra()+userDeduction.getHome_Loan()+userDeduction.getFixed_deposit()+userDeduction.getInsurance();

                    double leftAmount=sumOfSalary-sumOfDeduction;
                    double tax=0;
                    //System.out.println(tax+" "+sumOfSalary+sumOfDeduction);
                    if(leftAmount>0 && leftAmount<500000){
                        tax=leftAmount*0.10;
                    } else if (leftAmount>=500000 && leftAmount<1000000) {
                        tax=leftAmount*0.20;
                    } else if (leftAmount>=1000000) {
                        tax=leftAmount*0.25;
                    }

                    return "Income: "+sumOfSalary+" and Deduction: "+sumOfDeduction+
                            " remaining Income: "+leftAmount+" tax for that remaining amount is "
                            + tax + "after that tax remained balance is "+(leftAmount-tax);
            }else{
                logger.info("Please Check the Pan Number and secret key");
            }
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        return null;
    }
}
