package com.calculator.resource;

import com.calculator.entities.InterestValues;
import com.calculator.entities.MonthResult;
import com.calculator.services.CompoundInterestCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class CalculatorResource {

    private final CompoundInterestCalculator calculator;

    @Autowired
    public CalculatorResource(CompoundInterestCalculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<MonthResult>> calculateResults(@RequestBody InterestValues values) {
        List<MonthResult> results = calculator.totalResult(values);

        return ResponseEntity.ok().body(results);
    }

}
