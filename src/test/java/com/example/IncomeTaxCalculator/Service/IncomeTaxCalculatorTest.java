package com.example.IncomeTaxCalculator.Service;

import com.example.IncomeTaxCalculator.entity.User;
import com.example.IncomeTaxCalculator.entity.UserDeduction;
import com.example.IncomeTaxCalculator.entity.UserIncome;
import com.example.IncomeTaxCalculator.repository.UserDeductionRepo;
import com.example.IncomeTaxCalculator.repository.UserIncomeRepo;
import com.example.IncomeTaxCalculator.repository.UserRepo;
import com.example.IncomeTaxCalculator.service.IncomeService;
import com.example.IncomeTaxCalculator.service.IncomeServiceImpl;
import com.example.IncomeTaxCalculator.service.UserDeductionServiceImpl;
import com.example.IncomeTaxCalculator.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IncomeTaxCalculatorTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServiceImpl userServiceImpl;



    @Test
    public void testUserRegister1() {
        User user = new User(1, "abc", "a", "a@gmail.com", "YTR987654P", 123458, "10/2/20");

        Mockito.when(userRepo.save(user)).thenReturn(user);

        // Call the register method
        User registeredUser = userServiceImpl.register(user);

        // Assertions
        // Ensure that registeredUser is not null
        Assertions.assertNotNull(registeredUser);
        // Check that pan is equal to the original user's pan
        Assertions.assertEquals(user.getPan(), registeredUser.getPan());
    }

    @Test
    public void testUserRegister2() {
        User user1 = new User(1, "Temp", "ln", "temp@gmail.com", "YTR988654P", 123458, "10/2/20");

        Mockito.when(userRepo.save(user1)).thenReturn(user1);

        // Call the register method
        User registeredUser = userServiceImpl.register(user1);

        // Assertions
        // Ensure that registeredUser is not null
        Assertions.assertNotNull(registeredUser);
        // Check that pan is equal to the original user's pan

        Assertions.assertTrue(user1.getPan().length()==10);

    }

    @Mock
    private UserDeductionRepo userDeductionRepo;

    @InjectMocks
    private UserDeductionServiceImpl userDeductionServiceImpl;

    @Test
    public void testForUserDeduction(){
        UserDeduction userDeduction=new UserDeduction(1,25000,15000,50000,35000,45000,"YTR987654P");

        Mockito.when(userDeductionRepo.save(userDeduction)).thenReturn(userDeduction);

        UserDeduction add= userDeductionServiceImpl.add(userDeduction);

        Assertions.assertNotNull(userDeduction);

        Assertions.assertEquals(userDeduction.getUserDeductionId(), add.getUserDeductionId());

    }

    @Mock
    private UserIncomeRepo userIncomeRepo;

    @InjectMocks
    private IncomeServiceImpl incomeServiceImpl;

    @Test
    public void testForUserIncome(){
       UserIncome userIncome=new UserIncome(1,800000,20000,"YTR987654P");

        Mockito.when(userIncomeRepo.save(userIncome)).thenReturn(userIncome);

        UserIncome add= incomeServiceImpl.addIncome(userIncome);

        Assertions.assertNotNull(userIncome);

        //ssertions.assertFalse(userIncome.get);
        Assertions.assertTrue(userIncome.getUserIncomeId()==1);

    }







}
