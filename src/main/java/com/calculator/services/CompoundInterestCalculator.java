package com.calculator.services;

import com.calculator.entities.InputValues;
import com.calculator.entities.MonthResult;
import com.calculator.services.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
    Classe de serviço da aplicação
*/
@Service
public class CompoundInterestCalculator {

    /*
        Função responsável por receber a entrada do usuário e montar a lista de rendimentos que será retornada.
        @params: Capital inicial do investimento, Taxa de Juros e Período da aplicação.
        @return: Lista contendo os resultados mensais do investimento, retorna nulo caso a entrada esteja no formato inválido
    */
    public List<MonthResult> totalResult(Double principal, Double interestRate, Integer period) {
        validateInput(principal, interestRate, period);
        List<MonthResult> resultOverMonths = new ArrayList<>();
        Double principalOverMonth = principal;

        for (int month = 0; month <= period; month++) {
            MonthResult result = new MonthResult(month, principalOverMonth, interestRate);
            resultOverMonths.add(result);
            principalOverMonth = result.getPrincipal();
        }

        return resultOverMonths;
    }

    public List<MonthResult> totalResult(InputValues values) {
        return totalResult(values.getPrincipal(), values.getInterestRate(), values.getPeriod());
    }

    /*
        Função resposável por validar a entrada do usuário
        @params: Capital Inicial, Taxa de Juros e Período do investimento
        @return: Lança exceção caso algum valor esteja no formato inválido
    */
    private void validateInput(Double principal, Double interestRate, Integer period) {
        if (principal <= 0.0) throw new InvalidInputException("Principal must be a positive non-zero value");
        if (interestRate <= 0.0) throw new InvalidInputException("Interest Rate must be a positive non-zero value");
        if (period < 0) throw new InvalidInputException("Period must be a positive value");
    }
}
