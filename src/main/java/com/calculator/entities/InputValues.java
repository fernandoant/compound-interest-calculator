package com.calculator.entities;

/*
    Classe responsável por desserializar a entrada enviada pelo usuário através de uma requisição HTTP
*/
public class InputValues {

    // Capital - Valor a ser investido
    private final Double principal;
    // Taxa de Juros
    private final Double interestRate;
    // Prazo do investimento
    private final Integer period;

    /*
        Inicializa os valores do Capital, Taxa de Juros e Prazo de Investimento
     */
    public InputValues(Double principal, Double interestRate, Integer period) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.period = period;
    }

    // ----------- GETTERS -------------

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
