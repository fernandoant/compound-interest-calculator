package com.calculator;

import com.calculator.entities.InputValues;
import com.calculator.entities.MonthResult;
import com.calculator.services.CompoundInterestCalculator;
import com.calculator.services.exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CompoundInterestCalculatorApplicationTests {

	private final CompoundInterestCalculator calculator = new CompoundInterestCalculator();

	@Test
	void contextLoads() {
		assertThat(calculator).isNotNull();
	}

	@Test
	void incomeTests() {
		List<MonthResult> firstTest = calculator.totalResult(new InputValues(1000.0, 0.1, 6));

		assertThat(firstTest.get(1).getTotalValue()).isEqualTo(1100.00);
		assertThat(firstTest.get(2).getTotalValue()).isEqualTo(1210.00);
		assertThat(firstTest.get(3).getTotalValue()).isEqualTo(1331.00);
		assertThat(firstTest.get(4).getTotalValue()).isEqualTo(1464.10);
		assertThat(firstTest.get(5).getTotalValue()).isEqualTo(1610.51);
		assertThat(firstTest.get(6).getTotalValue()).isEqualTo(1771.56);

		List<MonthResult> secondTest = calculator.totalResult(new InputValues(25000.0, 0.04, 12));

		assertThat(secondTest.get(1).getTotalValue()).isEqualTo(26000.00);
		assertThat(secondTest.get(2).getTotalValue()).isEqualTo(27040.00);
		assertThat(secondTest.get(3).getTotalValue()).isEqualTo(28121.60);
		assertThat(secondTest.get(4).getTotalValue()).isEqualTo(29246.46);
		assertThat(secondTest.get(5).getTotalValue()).isEqualTo(30416.32);
		assertThat(secondTest.get(6).getTotalValue()).isEqualTo(31632.97);

		assertThat(secondTest.get(12).getTotalValue()).isEqualTo(40025.80);
	}

	@Test
	void returnRateTests() {
		List<MonthResult> firstTest = calculator.totalResult(new InputValues(1000.0, 0.1, 6));

		assertThat(firstTest.get(1).getInterestPercentage()).isEqualTo(0.1000);
		assertThat(firstTest.get(2).getInterestPercentage()).isEqualTo(0.2100);
		assertThat(firstTest.get(3).getInterestPercentage()).isEqualTo(0.3310);
		assertThat(firstTest.get(4).getInterestPercentage()).isEqualTo(0.4641);
		assertThat(firstTest.get(5).getInterestPercentage()).isEqualTo(0.6105);
		assertThat(firstTest.get(6).getInterestPercentage()).isEqualTo(0.7715);

		List<MonthResult> secondTest = calculator.totalResult(new InputValues(25000.0, 0.04, 10));

		assertThat(secondTest.get(1).getInterestPercentage()).isEqualTo(0.0400);
		assertThat(secondTest.get(2).getInterestPercentage()).isEqualTo(0.0816);
		assertThat(secondTest.get(3).getInterestPercentage()).isEqualTo(0.1248);
		assertThat(secondTest.get(4).getInterestPercentage()).isEqualTo(0.1698);
		assertThat(secondTest.get(5).getInterestPercentage()).isEqualTo(0.2166);
		assertThat(secondTest.get(6).getInterestPercentage()).isEqualTo(0.2653);
	}

	@Test
	public void zeroedPrincipalInput_should_throw_exception() {

		String expectedMessage = "Principal must be a positive non-zero value";
		Exception exception = assertThrows(InvalidInputException.class,
				() -> calculator.totalResult(new InputValues(0.0, 0.02, 5)));

		String actualMessage = exception.getMessage();
		assert(actualMessage.equals(expectedMessage));
	}

	@Test
	public void negativePrincipalInput_should_throw_exception() {
		String expectedMessage = "Principal must be a positive non-zero value";
		Exception exception = assertThrows(InvalidInputException.class,
				() -> calculator.totalResult(new InputValues(-100.0, 0.02, 5)));

		String actualMessage = exception.getMessage();
		assert(actualMessage.equals(expectedMessage));
	}

	@Test
	public void zeroedInterestRateInput_should_throw_exception() {
		String expectedMessage = "Interest Rate must be a positive non-zero value";
		Exception exception = assertThrows(InvalidInputException.class,
				() -> calculator.totalResult(new InputValues(100.0, 0.0, 5)));

		String actualMessage = exception.getMessage();
		assert(actualMessage.equals(expectedMessage));
	}

	@Test
	public void negativeInterestRateInput_should_throw_exception() {
		String expectedMessage = "Interest Rate must be a positive non-zero value";
		Exception exception = assertThrows(InvalidInputException.class,
				() -> calculator.totalResult(new InputValues(100.0, -0.5, 5)));

		String actualMessage = exception.getMessage();
		assert(actualMessage.equals(expectedMessage));
	}

	@Test
	public void negativePeriodInput_should_throw_exception() {
		String expectedMessage = "Period must be a positive value";
		Exception exception = assertThrows(InvalidInputException.class,
				() -> calculator.totalResult(new InputValues(100.0, 0.01, -5)));

		String actualMessage = exception.getMessage();
		assert(actualMessage.equals(expectedMessage));
	}
}
