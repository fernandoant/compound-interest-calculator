package com.calculator.entities;

/*
    Classe responsável por armazenar as informações do rendimento mês a mês
*/
public class MonthResult {

    // Mês de referência
    private final Integer month;
    // Capital inicial
    private final Double principal;
    // Taxa de Juros
    private final Double interestRate;
    // Valor total (Capital inicial + juros)
    private final Double totalValue;

    /*
        Construtora responsável por inicializar as informações de Mês de Referência, Capital
        e Taxa de Juros, além de chamar a função responsável por calcular o Valor Total
    */
    public MonthResult(Integer month, Double principal, Double interestRate) {
        this.month = month;
        this.principal = principal;
        this.interestRate = interestRate;
        this.totalValue = calculateInterestValue();
    }

    /*
        Função responsável por calcular o valor total de rendimentos
        @param: none
        @return: Valor total de Rendimentos (Capital + Juros)
    */
    private Double calculateInterestValue() {
        return principal * Math.pow((1 + interestRate), month);
    }

    /*
        Retorna o mês de referência.
        @param: none
        @return: mês de referência
    */
    public Integer getMonth() {
        return month;
    }

    /*
        Retorna o Capital Inicial, arredondado para duas casas decimais
        @param: none
        @return: Capital Inicial
    */
    public Double getPrincipal() {
        return (Math.floor(principal * 100)) / 100;
    }

    /*
        Retorna a Taxa de Juros
        @param: none
        @return: Taxa de Juros
    */
    public Double getInterestRate() {
        return interestRate;
    }

    /*
        Retorna o valor total do investimento no mês de referência,
        arredondado para duas casas decimais
        @param: none
        @return: Valor total do investimento (Capital Inicial + Juros)
    */
    public Double getTotalValue() {
        return (Math.floor(totalValue * 100)) / 100;
    }

    /*
        Retorna a porcentagem de juros incidente sobre o capital inicial
        @param: none
        @return: Porcentagem de juros incidente sobre o capital inicial, arredondado para
        quatro casas decimais
    */
    public Double getInterestPercentage() {
        return Math.floor(((totalValue - principal) / principal) * 10000) / 10000;
    }

    @Override
    public String toString() {
        return "MonthResult{" +
                "month=" + month +
                ", principal=" + principal +
                ", interestRate=" + interestRate +
                ", interestValue=" + totalValue +
                '}';
    }
}
