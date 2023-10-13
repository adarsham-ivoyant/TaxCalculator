package com.example.IncomeTaxCalculator;

import com.example.IncomeTaxCalculator.entity.User;
import com.example.IncomeTaxCalculator.entity.UserDeduction;
import com.example.IncomeTaxCalculator.entity.UserIncome;
import com.example.IncomeTaxCalculator.repository.UserDeductionRepo;
import com.example.IncomeTaxCalculator.repository.UserIncomeRepo;
import com.example.IncomeTaxCalculator.repository.UserRepo;
import com.example.IncomeTaxCalculator.service.IncomeService;
import com.example.IncomeTaxCalculator.service.UserDeductionService;
import com.example.IncomeTaxCalculator.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class IncomeTaxCalculatorApplicationTests {



	//Adding Test case for User Entity
	@Autowired
	private UserService userService;

	@MockBean
	private UserRepo userRepo;

	@Test
	public void saveUserTest(){
		User user =new User(1,"abc","a","a@gmail.com","YTR987654P",123458,"10/2/20");
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user,userService.register(user));
	}

	@Test
	public void getAllUserTest(){
		when(userRepo.findAll()).thenReturn(Stream
				.of(new User(1,"abc","a","a@gmail.com","YTR987654P",123458,"10/2/20"),
						new User(3,"xyz","ll","xyz@gmail.com","LYT987654P",874521,"10/12/91"),
						new User(2,"temp","t","temp@gmail.com","PYR873644P",123258,"11/4/18")).collect(Collectors.toList()));

		assertEquals(3,userService.getAllUser().size());
	}

	//Adding Test case for UserDeduction Entity
	@Autowired
	private UserDeductionService userDeductionService;

	@MockBean
	private UserDeductionRepo userDeductionRepo;

	@Test
	public void getAllUserDeductionTest(){
		when(userDeductionRepo.findAll()).thenReturn(Stream
				.of(new UserDeduction(1,25000,15000,50000,35000,45000,"YTR987654P"),
						new UserDeduction(2,20000,10000,80000,50000,25000,"PYR873644P")).collect(Collectors.toList()));

		assertEquals(2,userDeductionService.getAllUserDeduction().size());
	}

	@Test
	public void saveUserDeductionTest(){
		UserDeduction userDeduction =new UserDeduction(1,25000,15000,50000,35000,45000,"YTR987654P");
		when(userDeductionRepo.save(userDeduction)).thenReturn(userDeduction);
		assertEquals(userDeduction,userDeductionService.add(userDeduction));
	}

	//Adding Test case for UserIncome Entity
	@Autowired
	private IncomeService incomeService;
	@MockBean
	private UserIncomeRepo userIncomeRepo;

	@Test
	public void getAllUserIncomeTest(){
		when(userIncomeRepo.findAll()).thenReturn(Stream
				.of(new UserIncome(1,800000,20000,"YTR987654P"),
						new UserIncome(2,600000,400000,"UYT123456P")).collect(Collectors.toList()));

		assertEquals(2,incomeService.getAllUserIncome().size());
	}

	@Test
	public void saveUserIncomeTest(){
		UserIncome userIncome =new UserIncome(1,800000,20000,"YTR987654P");
		when(userIncomeRepo.save(userIncome)).thenReturn(userIncome);
		assertEquals(userIncome,incomeService.addIncome(userIncome));
	}

	@Test
	void contextLoads() {
	}

}
