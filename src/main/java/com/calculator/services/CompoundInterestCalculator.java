package com.calculator.services;

import com.calculator.entities.InterestValues;
import com.calculator.entities.MonthResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompoundInterestCalculator {

    public List<MonthResult> totalResult(Double principal, Double interestRate, Integer period) {
        List<MonthResult> resultOverMonths = new ArrayList<>();
        Double principalOverMonth = principal;

        for (int month = 1; month <= period; month++) {
            MonthResult result = new MonthResult(month, principalOverMonth, interestRate);
            resultOverMonths.add(result);
            principalOverMonth = result.getPrincipal();
        }

        return resultOverMonths;
    }

    public List<MonthResult> totalResult(InterestValues values) {
        return totalResult(values.getPrincipal(), values.getInterestRate(), values.getPeriod());
    }

}
