package com.calculator.entities;

public class InterestValues {

    private final Double principal;
    private final Double interestRate;
    private final Integer period;

    public InterestValues(Double principal, Double interestRate, Integer period) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.period = period;
    }

    public Double getPrincipal() {
        return principal;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Integer getPeriod() {
        return period;
    }

    @Override
    public String toString() {
        return "InterestValues{" +
                "principal=" + principal +
                ", interestRate=" + interestRate +
                ", period=" + period +
                '}';
    }
}
