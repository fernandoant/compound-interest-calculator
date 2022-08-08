package com.calculator.resource;

import com.calculator.entities.InputValues;
import com.calculator.entities.MonthResult;
import com.calculator.services.CompoundInterestCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    Classe controladora responsável por interceptar as requisições HTTP e retornar uma resposta
*/

@RestController
@RequestMapping()
public class CalculatorResource {

    // Injeção de dependênicia da classe de serviço da aplicação
    private final CompoundInterestCalculator calculator;

    @Autowired
    public CalculatorResource(CompoundInterestCalculator calculator) {
        this.calculator = calculator;
    }

    /*
        Função executada ao receber uma requisição HTTP
        param: Capital Inicial, Taxa de Juros e Período da aplicação,
            os parâmetros são encapsulados na classe InputValues
        return: Retorna status 200 e a lista de resultados mensais da aplicação caso
            não ocorra nenhum erro.
            Retorna status 400 (Bad Request) caso algum parâmetro esteja no formato inválido.
    */
    @GetMapping(value = "/")
    public ResponseEntity<List<MonthResult>> calculateResults(@RequestBody InputValues values) {
        List<MonthResult> results = calculator.totalResult(values);
        return ResponseEntity.ok().body(results);
    }

}
