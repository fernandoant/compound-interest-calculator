package com.calculator.entities;

public class MonthResult {

    private final Integer month;
    private final Double principal;
    private final Double interestRate;
    private final Double interestValue;

    public MonthResult(Integer month, Double principal, Double interestRate) {
        this.month = month;
        this.principal = principal;
        this.interestRate = interestRate;
        this.interestValue = calculateInterestValue();
    }

    public Double calculateInterestValue() {
        checkValues();
        return principal * Math.pow((1 + interestRate), month);
    }

    public Integer getMonth() {
        return month;
    }

    public Double getPrincipal() {
        return (Math.floor(principal * 100)) / 100;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Double getInterestValue() {
        // Valor arredondado para duas casas decimais
        return (Math.floor(interestValue * 100)) / 100;
    }

    public Double getInterestPercentage() {
        // Valor arredondado para quatro casas decimais
        return Math.floor(((interestValue - principal) / principal) * 10000) / 10000;
    }

    @Override
    public String toString() {
        return "MonthResult{" +
                "month=" + month +
                ", principal=" + principal +
                ", interestRate=" + interestRate +
                ", interestValue=" + interestValue +
                '}';
    }

    private void checkValues() {
        if (this.month < 0) throw new IllegalStateException("Period must be a positive number");
        if (this.principal <= 0) throw new IllegalStateException("Principal must be a positive non-zero value");
        if (this.interestRate <= 0) throw new IllegalStateException("Interest Rate must be a positive non-zero value");
    }
}
