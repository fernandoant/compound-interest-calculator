package com.calculator;

import com.calculator.entities.InterestValues;
import com.calculator.entities.MonthResult;
import com.calculator.services.CompoundInterestCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CompoundInterestCalculatorApplicationTests {

	private final CompoundInterestCalculator calculator = new CompoundInterestCalculator();

	@Test
	void contextLoads() {
		assertThat(calculator).isNotNull();
	}

	@Test
	void incomeTests() {
		List<MonthResult> firstTest = calculator.totalResult(new InterestValues(1000.0, 0.1, 6));

		assertThat(firstTest.get(0).getInterestValue()).isEqualTo(1100.00);
		assertThat(firstTest.get(1).getInterestValue()).isEqualTo(1210.00);
		assertThat(firstTest.get(2).getInterestValue()).isEqualTo(1331.00);
		assertThat(firstTest.get(3).getInterestValue()).isEqualTo(1464.10);
		assertThat(firstTest.get(4).getInterestValue()).isEqualTo(1610.51);
		assertThat(firstTest.get(5).getInterestValue()).isEqualTo(1771.56);

		List<MonthResult> secondTest = calculator.totalResult(new InterestValues(25000.0, 0.04, 10));

		assertThat(secondTest.get(0).getInterestValue()).isEqualTo(26000.00);
		assertThat(secondTest.get(1).getInterestValue()).isEqualTo(27040.00);
		assertThat(secondTest.get(2).getInterestValue()).isEqualTo(28121.60);
		assertThat(secondTest.get(3).getInterestValue()).isEqualTo(29246.46);
		assertThat(secondTest.get(4).getInterestValue()).isEqualTo(30416.32);
		assertThat(secondTest.get(5).getInterestValue()).isEqualTo(31632.97);
	}

	@Test
	void returnRateTests() {
		List<MonthResult> firstTest = calculator.totalResult(new InterestValues(1000.0, 0.1, 6));

		assertThat(firstTest.get(0).getInterestPercentage()).isEqualTo(0.1000);
		assertThat(firstTest.get(1).getInterestPercentage()).isEqualTo(0.2100);
		assertThat(firstTest.get(2).getInterestPercentage()).isEqualTo(0.3310);
		assertThat(firstTest.get(3).getInterestPercentage()).isEqualTo(0.4641);
		assertThat(firstTest.get(4).getInterestPercentage()).isEqualTo(0.6105);
		assertThat(firstTest.get(5).getInterestPercentage()).isEqualTo(0.7715);

		List<MonthResult> secondTest = calculator.totalResult(new InterestValues(25000.0, 0.04, 10));

		assertThat(secondTest.get(0).getInterestPercentage()).isEqualTo(0.0400);
		assertThat(secondTest.get(1).getInterestPercentage()).isEqualTo(0.0816);
		assertThat(secondTest.get(2).getInterestPercentage()).isEqualTo(0.1248);
		assertThat(secondTest.get(3).getInterestPercentage()).isEqualTo(0.1698);
		assertThat(secondTest.get(4).getInterestPercentage()).isEqualTo(0.2166);
		assertThat(secondTest.get(5).getInterestPercentage()).isEqualTo(0.2653);
	}

}
